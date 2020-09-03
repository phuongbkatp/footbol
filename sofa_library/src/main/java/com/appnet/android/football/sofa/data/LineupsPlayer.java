package com.appnet.android.football.sofa.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LineupsPlayer {
    @SerializedName("player")
    @Expose
    private Person player;
    @SerializedName("shirtNumber")
    @Expose
    private int shirtNumber;
    @SerializedName("captain")
    @Expose
    private boolean captain;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("positionNameshort")
    @Expose
    private String positionNameshort;
    @SerializedName("substitute")
    @Expose
    private boolean substitute;

    public Person getPlayer() {
        return player;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public boolean isCaptain() {
        return captain;
    }

    public String getRating() {
        return rating;
    }

    public String getPositionNameshort() {
        return positionNameshort;
    }

    public boolean isSubstitute() {
        return substitute;
    }
}
