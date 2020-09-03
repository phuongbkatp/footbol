package com.appnet.android.football.fbvn.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamSquad {
    @SerializedName("coach")
    @Expose
    private Coach coach;
    @SerializedName("players")
    @Expose
    private List<Player> players;

    public Coach getCoach() {
        return coach;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
