package com.dianping.cat.message.facade.rpc;

import com.dianping.cat.message.facade.channel.RpcStateChannel;
import com.google.protobuf.Message;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.BiFunction;

public class GRpcCall<REQUEST extends Message, RESPONSE> {

    private final ConsistentHashChannelPool channelPool;

    private final String hashKey;

    private RpcStateChannel rpcStateChannel;

    private long rpcStartTime;

    private final REQUEST request;

    private Future<RESPONSE> responseFuture;

    private BiFunction<RpcStateChannel, REQUEST, Future<RESPONSE>> call;

    public GRpcCall(ConsistentHashChannelPool channelPool, String hashKey, REQUEST request) {
        this.channelPool = channelPool;
        this.hashKey = hashKey;
        this.request = request;
    }

    public void asyncCall(BiFunction<RpcStateChannel, REQUEST, Future<RESPONSE>> call) {
        this.call = call;
        doAsyncCall();
    }

    private void doAsyncCall() {
        this.rpcStateChannel = channelPool.select(this.hashKey);
        this.rpcStateChannel.getHit().incrementAndGet();
        this.rpcStartTime = System.currentTimeMillis();

        this.responseFuture = call.apply(rpcStateChannel, this.request);
    }

    public RESPONSE get() {
        try {
            try {
                return this.responseFuture.get();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw Status.CANCELLED.withDescription("rpc call was interrupted").withCause(e).asRuntimeException();
            } catch (ExecutionException e) {
                throw formatRpcException(e.getCause());
            }
        } catch (StatusRuntimeException e) {
            if (this.channelPool != null) {
                if (e.getStatus().getCode() == Status.Code.UNAVAILABLE) {
                    this.channelPool.disableChannel(this.rpcStateChannel);
                }

                if (e.getStatus().getCode() == Status.Code.DEADLINE_EXCEEDED || e.getStatus().getCode() == Status.Code.RESOURCE_EXHAUSTED) {
                    // TODO
                }
            }

            String message = String.format("do rpc call failed, request=[%s], channel=[%s], hashKey=[%s], cost=[%d], msg=[%s]",
                    request.getDescriptorForType().getName(),
                    this.rpcStateChannel.getAddress(),
                    hashKey,
                    System.currentTimeMillis() - rpcStartTime,
                    e.getMessage());
            throw new RuntimeException(message, e);
        }
    }

    public RESPONSE getWithRetry() {
        try {
            return get();
        } catch (Exception e) {
            doAsyncCall();
            return get();
        }
    }

    private StatusRuntimeException formatRpcException(Throwable t) {
        Throwable cause = t;
        while (cause != null) {
            if (cause instanceof StatusException) {
                StatusException se = (StatusException) cause;
                return new StatusRuntimeException(se.getStatus(), se.getTrailers());
            }

            if (cause instanceof StatusRuntimeException) {
                StatusRuntimeException sre = (StatusRuntimeException) cause;
                return new StatusRuntimeException(sre.getStatus(), sre.getTrailers());
            }

            cause = cause.getCause();
        }
        throw Status.UNKNOWN.withDescription("unknown error").withCause(t).asRuntimeException();
    }
}
