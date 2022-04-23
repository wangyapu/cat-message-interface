package com.dianping.cat.message.facade.client;

import com.dianping.cat.message.facade.channel.ChannelHealthChecker;
import com.dianping.cat.message.facade.proto.ChannelHealthCheckRequest;
import com.dianping.cat.message.facade.proto.ChannelHealthCheckServiceGrpc;
import com.dianping.cat.message.facade.rpc.ConsistentHashChannelPool;

import java.net.InetAddress;
import java.util.concurrent.ThreadPoolExecutor;

public class MessageSendClient {

    private static volatile MessageSendClient instance;

    protected ThreadPoolExecutor threadExecutor;

    protected ConsistentHashChannelPool pool;

    public MessageSendClient(ServerListLoader serverListLoader, ThreadPoolExecutor threadExecutor) {
        ChannelHealthChecker healthChecker = channel -> {
            ChannelHealthCheckRequest request;
            try {
                request = ChannelHealthCheckRequest.newBuilder()
                        .setClientIp(InetAddress.getLocalHost().getHostAddress()).build();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return ChannelHealthCheckServiceGrpc.newBlockingStub(channel).healthCheck(request).getEnable();
        };

        this.threadExecutor = threadExecutor;
    }

    public static MessageSendClient getInstance(ServerListLoader serverListLoader, ThreadPoolExecutor threadExecutor) {
        if (instance == null) {
            synchronized (MessageSendClient.class) {
                if (instance == null) {
                    try {
                        instance = new MessageSendClient(serverListLoader, threadExecutor);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return instance;
    }

}
