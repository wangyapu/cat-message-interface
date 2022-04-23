package com.dianping.cat.message.facade.rpc;

import com.dianping.cat.message.facade.channel.ChannelHealthChecker;
import com.dianping.cat.message.facade.channel.RpcStateChannel;
import com.dianping.cat.message.facade.client.ServerListLoader;
import com.dianping.cat.message.facade.model.ServerNode;
import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import io.netty.channel.ChannelOption;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ConsistentHashChannelPool {

    private final Map<String, RpcStateChannel> channels = new ConcurrentHashMap<>();

    private final ConsistentHashRouter router = new ConsistentHashRouter(1024);

    private final ServerListLoader serverListLoader;
    private final ChannelHealthChecker healthChecker;

    private volatile boolean closed = false;

    public ConsistentHashChannelPool(
            ServerListLoader serverListLoader,
            ChannelHealthChecker healthChecker
    ) {
        List<ServerNode> servers = serverListLoader.load();
        if (servers == null || servers.isEmpty()) {
            throw new RuntimeException("load empty server list");
        }

        this.serverListLoader = serverListLoader;
        this.healthChecker = healthChecker;

        for (ServerNode server : servers) {
            String ip = server.getIp();
            int port = server.getPort();

            ManagedChannel channel = NettyChannelBuilder.forAddress(ip, port)
                    .usePlaintext()
                    .withOption(ChannelOption.CONNECT_TIMEOUT_MILLIS, 1000)
                    .maxInboundMessageSize(10 * 110 * 1024 * 1024)
                    .build();

            String address = server.address();
            RpcStateChannel rpcStateChannel = new RpcStateChannel(address, channel);
            this.channels.put(address, rpcStateChannel);
            this.router.addNode(address);
        }

        doChannelStateCheck();
    }

    private void doChannelStateCheck() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(this::manageChannel, 0, 30000, TimeUnit.MILLISECONDS);
    }

    private void manageChannel() {
        try {
            if (closed) {
                return;
            }

            checkServerState();
            updateServers();
        } catch (Exception e) {
            // ignore
        }
    }

    private void checkServerState() {
        this.channels.forEach((server, rpcStateChannel) -> {
            if (!rpcStateChannel.isHealthy()) {
                this.router.removeNode(server);

                boolean success = healthChecker.healthCheck(rpcStateChannel.getChannel());

                if (success) {
                    rpcStateChannel.setHealthy(true);
                    this.router.addNode(server);
                }
            } else {
                if (!this.router.exist(server)) {
                    this.router.addNode(server);
                }
            }
        });

    }

    private void updateServers() {
        List<ServerNode> servers = this.serverListLoader.load();
        if (!servers.isEmpty()) {
            Set<String> serverAddresses = servers.stream().map(ServerNode::address).collect(Collectors.toSet());
            addNewServers(servers);
            delInvalidServers(serverAddresses);
        }
    }

    private void delInvalidServers(Set<String> serverAddresses) {
        List<String> toDel = new ArrayList<>();
        this.channels.forEach((server, rpcStateChannel) -> {
            if (!serverAddresses.contains(server)) {
                this.router.removeNode(server);
                toDel.add(server);
            }
        });

        for (String delServer : toDel) {
            RpcStateChannel channel = this.channels.remove(delServer);
            if (channel != null) {
                channel.getChannel().shutdown();
            }
        }
    }

    private void addNewServers(List<ServerNode> servers) {
        for (ServerNode server : servers) {
            String address = server.address();
            if (!this.channels.containsKey(address)) {
                ManagedChannel channel = NettyChannelBuilder.forAddress(server.getIp(), server.getPort())
                        .usePlaintext()
                        .withOption(ChannelOption.CONNECT_TIMEOUT_MILLIS, 1000)
                        .maxInboundMessageSize(10 * 110 * 1024 * 1024)
                        .build();

                RpcStateChannel rpcStateChannel = new RpcStateChannel(address, channel);
                this.channels.put(address, rpcStateChannel);
                this.router.addNode(address);
            }
        }
    }

    public RpcStateChannel select(String hashKey) {
        String serverAddress = router.select(hashKey);

        if (serverAddress == null) {
            throw new RuntimeException("no channel for hash key " + hashKey);
        }

        return this.channels.get(serverAddress);
    }

    public void disableChannel(RpcStateChannel rpcStateChannel) {
        rpcStateChannel.setHealthy(false);
        this.router.removeNode(rpcStateChannel.getAddress());
    }

    public void close() {
        this.closed = true;
        this.channels.values().forEach(rpcStateChannel -> rpcStateChannel.getChannel().shutdown());
    }
}
