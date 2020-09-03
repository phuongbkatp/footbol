package com.appnet.android.football.sofa.data;

import java.util.List;

public class WebApiDataResponse {
    private SportItem sportItem;

    public SportItem getSportItem() {
        return sportItem;
    }

    public List<GameTournament> getTournaments() {
        if(sportItem == null) {
            return null;
        }
        return sportItem.getTournaments();
    }
}
