package com.appnet.android.football.sofa.data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GameTournament {
    @SerializedName("tournament")
    @Expose
    private Tournament tournament;

    @SerializedName("events")
    @Expose
    private List<Event> events;

    @SerializedName("season")
    @Expose
    private Season season;

    private transient boolean isEventTournament = false;

    public Tournament getTournament() {
        return tournament;
    }

    public List<Event> getEvents() {
        if(events != null && !isEventTournament) {
            isEventTournament = true;
            if(season != null && tournament != null) {
                tournament.setCurrentSeasonId(season);
            }
            for(Event event : events) {
                event.setTournament(tournament);
            }
        }
        return events;
    }

    public Event getEvent() {
        List<Event> data = getEvents();
        if(data == null || data.isEmpty()) {
            return null;
        }
        return data.get(0);
    }

    public Season getSeason() {
        return season;
    }
}
