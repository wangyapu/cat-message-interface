package com.dianping.cat.message.facade.channel;

import io.grpc.ManagedChannel;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class RpcStateChannel {

    private final String address;

    private final ManagedChannel channel;

    private volatile boolean healthy = true;

    private final AtomicLong hit = new AtomicLong(0);

    private final AtomicInteger fail = new AtomicInteger(0);

    public RpcStateChannel(String address, ManagedChannel channel) {
        this.address = address;
        this.channel = channel;
    }

    public String getAddress() {
        return address;
    }

    public ManagedChannel getChannel() {
        return channel;
    }

    public boolean isHealthy() {
        return healthy;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    public AtomicLong getHit() {
        return hit;
    }

    public AtomicInteger getFail() {
        return fail;
    }

}
