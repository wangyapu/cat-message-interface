package com.dianping.cat.message.facade.client;

import com.dianping.cat.message.facade.model.ServerNode;

import java.util.List;

@FunctionalInterface
public interface ServerListLoader {
    List<ServerNode> load();
}
