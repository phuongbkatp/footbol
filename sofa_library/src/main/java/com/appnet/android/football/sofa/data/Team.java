package com.appnet.android.football.sofa.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("shortName")
    @Expose
    private String shortName;
    @SerializedName("name")
    @Expose
    private String name;
    private long foundationDateTimestamp;

    private Venue venue;
    private TeamColor teamColors;
    private Manager manager;
    private TeamTransfer transfers;

    public int getId() {
        return id;
    }

    public String getShortName() {
        return shortName;
    }

    public String getName() {
        return name;
    }

    public long getFoundationDateTimestamp() {
        return foundationDateTimestamp*1000;
    }

    public Venue getVenue() {
        return venue;
    }

    public TeamColor getTeamColors() {
        return teamColors;
    }

    public Manager getManager() {
        return manager;
    }

    public TeamTransfer getTransfers() {
        return transfers;
    }
}
