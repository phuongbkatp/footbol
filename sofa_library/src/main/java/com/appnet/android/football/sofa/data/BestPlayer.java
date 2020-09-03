package com.appnet.android.football.sofa.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BestPlayer {
    @SerializedName("player")
    @Expose
    private Person player;
    @SerializedName("value")
    @Expose
    private String value;

    public Person getPlayer() {
        return player;
    }

    public String getValue() {
        return value;
    }
}
