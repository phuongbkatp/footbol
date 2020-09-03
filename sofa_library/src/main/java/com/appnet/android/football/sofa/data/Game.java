package com.appnet.android.football.sofa.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Game {
    @SerializedName("tournaments")
    @Expose
    private List<GameTournament> tournaments;

    public List<GameTournament> getTournaments() {
        return tournaments;
    }
}
