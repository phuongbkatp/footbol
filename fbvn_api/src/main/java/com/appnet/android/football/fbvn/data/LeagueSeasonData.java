package com.appnet.android.football.fbvn.data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeagueSeasonData {
    @SerializedName("leagueSeasons")
    @Expose
    private List<LeagueSeason> leagueSeasons;

    public List<LeagueSeason> getLeagueSeasons() {
        return leagueSeasons;
    }
}
