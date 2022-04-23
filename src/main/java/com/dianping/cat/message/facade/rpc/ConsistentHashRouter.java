package com.dianping.cat.message.facade.rpc;

import com.dianping.cat.message.facade.model.VirtualNode;
import com.dianping.cat.message.facade.util.MurmurHash;

import java.util.SortedMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConsistentHashRouter {

    private final SortedMap<Long, VirtualNode> ring = new ConcurrentSkipListMap<>();

    private final int virtualNodeCount;

    public ConsistentHashRouter(int virtualNodeCount) {
        this.virtualNodeCount = virtualNodeCount;
    }

    public void addNode(String physicalNode) {
        for (int i = 0; i < virtualNodeCount; i++) {
            VirtualNode virtualNode = new VirtualNode(physicalNode, i);
            ring.put(MurmurHash.hash(virtualNode.address()), virtualNode);
        }
    }

    public void removeNode(String physicalNode) {
        for (int i = 0; i < virtualNodeCount; i++) {
            VirtualNode virtualNode = new VirtualNode(physicalNode, i);
            ring.remove(MurmurHash.hash(virtualNode.address()));
        }
    }

    public String select(String key) {
        if (ring.isEmpty()) {
            return null;
        }

        long hash = MurmurHash.hash(key);
        SortedMap<Long, VirtualNode> tailMap = ring.tailMap(hash);
        if (!tailMap.isEmpty()) {
            return ring.get(tailMap.firstKey()).getPhysicalNode();
        }
        return ring.get(ring.firstKey()).getPhysicalNode();
    }

    public boolean exist(String physicalNode) {
        for (int i = 0; i < virtualNodeCount; i++) {
            VirtualNode virtualNode = new VirtualNode(physicalNode, i);
            if (ring.containsKey(MurmurHash.hash(virtualNode.address()))) {
                return true;
            }
        }
        return false;
    }
}
