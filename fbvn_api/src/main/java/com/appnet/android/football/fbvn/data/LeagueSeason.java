package com.appnet.android.football.fbvn.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeagueSeason {
    @SerializedName("sofa_id")
    @Expose
    private int sofaId;
    @SerializedName("league")
    @Expose
    private League league;

    public int getSofaId() {
        return sofaId;
    }

    public League getLeague() {
        return league;
    }

    public int getSofaLeagueId() {
        if(league == null) {
            return 0;
        }
        return league.getSofaId();
    }

    public String getLeagueLogo() {
        if(league == null) {
            return "";
        }
        return league.getLogo();
    }

    public String getLeagueName() {
        if(league == null) {
            return "";
        }
        return league.getName();
    }
}
