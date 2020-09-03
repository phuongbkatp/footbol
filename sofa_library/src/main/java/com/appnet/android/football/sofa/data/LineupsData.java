package com.appnet.android.football.sofa.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LineupsData {
    @SerializedName("confirmed")
    @Expose
    private boolean confirmed;
    @SerializedName("home")
    @Expose
    private List<LineupsPlayer> home;
    @SerializedName("away")
    @Expose
    private List<LineupsPlayer> away;
    @SerializedName("homeFormation")
    @Expose
    private String homeFormation;
    @SerializedName("awayFormation")
    @Expose
    private String awayFormation;

    @SerializedName("homeManager")
    @Expose
    private Person homeManager;
    @SerializedName("awayManager")
    @Expose
    private Person awayManager;

    public boolean isConfirmed() {
        return confirmed;
    }

    public List<LineupsPlayer> getHome() {
        return home;
    }

    public List<LineupsPlayer> getAway() {
        return away;
    }

    public String getHomeFormation() {
        return homeFormation;
    }

    public String getAwayFormation() {
        return awayFormation;
    }

    public Person getHomeManager() {
        return homeManager;
    }

    public Person getAwayManager() {
        return awayManager;
    }
}
