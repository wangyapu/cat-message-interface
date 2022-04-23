package com.dianping.cat.message.facade.channel;

import io.grpc.ManagedChannel;

@FunctionalInterface
public interface ChannelHealthChecker {
    boolean healthCheck(ManagedChannel channel);
}
