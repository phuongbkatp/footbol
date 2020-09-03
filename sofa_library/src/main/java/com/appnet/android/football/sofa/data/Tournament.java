package com.appnet.android.football.sofa.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tournament {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("uniqueId")
    @Expose
    private int uniqueId;

    private transient Season currentSeason;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public Season getCurrentSeason() {
        return currentSeason;
    }

    public void setCurrentSeasonId(Season currentSeason) {
        this.currentSeason = currentSeason;
    }
}
