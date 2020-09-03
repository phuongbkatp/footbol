package com.appnet.android.football.sofa.data;

import java.util.List;

public class CupTreeRound {
    private int id;
    private int type;
    private int order;
    private String description;
    private List<Block> blocks;

    public int getId() {
        return id;
    }

    public int getOrder() {
        return order;
    }

    public String getDescription() {
        return description;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public int getType() {
        return type;
    }
}
