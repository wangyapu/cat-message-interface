package com.dianping.cat.message.facade.model;

public class VirtualNode implements INode {

    private final String physicalNode;

    private final int index;

    public VirtualNode(String physicalNode, int index) {
        this.physicalNode = physicalNode;
        this.index = index;
    }

    @Override
    public String address() {
        return physicalNode + "_" + index;
    }

    public String getPhysicalNode() {
        return physicalNode;
    }
}
