package com.appnet.android.football.fbvn.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeagueData {
    @SerializedName("data")
    @Expose
    private List<League> data;

    public List<League> getData() {
        return data;
    }
}
