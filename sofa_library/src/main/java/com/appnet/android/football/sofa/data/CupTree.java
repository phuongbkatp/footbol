package com.appnet.android.football.sofa.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CupTree {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("currentRound")
    @Expose
    private int currentRound;

    @SerializedName("rounds")
    @Expose
    private List<CupTreeRound> rounds;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public List<CupTreeRound> getRounds() {
        return rounds;
    }
}
