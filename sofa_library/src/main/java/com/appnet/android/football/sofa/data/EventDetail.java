package com.appnet.android.football.sofa.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventDetail {
    @SerializedName("game")
    @Expose
    private Game game;

    public Game getGame() {
        return game;
    }

    public GameTournament getGameTournament() {
        if(game == null) {
            return null;
        }
        if(game.getTournaments() == null || game.getTournaments().isEmpty()) {
            return null;
        }
        return game.getTournaments().get(0);
    }
}
