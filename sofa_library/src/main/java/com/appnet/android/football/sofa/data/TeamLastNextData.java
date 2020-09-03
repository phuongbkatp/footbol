package com.appnet.android.football.sofa.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TeamLastNextData {
    private static final int MAX = 5;

    @SerializedName("last")
    @Expose
    private Game last;
    @SerializedName("next")
    @Expose
    private Game next;

    private transient List<Event> lastEvents;
    private transient List<Event> nextEvents;
    private transient List<Event> lastNextEvents;

    public List<Event> getLastEvents() {
        if(lastEvents == null) {
            lastEvents = new ArrayList<>();
            if(last != null && last.getTournaments() != null) {
                int size = last.getTournaments().size();
                size = (size > MAX) ? MAX : size;
                for(int i = 0; i < size; i++) {
                    lastEvents.addAll(last.getTournaments().get(i).getEvents());
                }
            }
        }
        return lastEvents;
    }

    public List<Event> getNextEvents() {
        if(nextEvents == null) {
            nextEvents = new ArrayList<>();
            if(next != null && next.getTournaments() != null) {
                int size = next.getTournaments().size();
                size = (size > MAX) ? MAX : size;
                for(int i = 0; i < size; i++) {
                    nextEvents.addAll(next.getTournaments().get(i).getEvents());
                }
            }
        }
        return nextEvents;
    }

    public List<Event> getLastNextEvents() {
        if(lastNextEvents == null) {
            lastNextEvents = new ArrayList<>();
            int size = getLastEvents().size();
            size = (size > MAX) ? MAX : size;
            if(size > 0) {
                for (int i = size - 1; i >= 0; i--) {
                    lastNextEvents.add(getLastEvents().get(i));
                }
            }
            size = getNextEvents().size();
            size = (size > MAX) ? MAX : size;
            for(int i = 0; i < size; i++) {
                lastNextEvents.add(getNextEvents().get(i));
            }
        }
        return lastNextEvents;
    }

    public Game getLast() {
        return last;
    }

    public Game getNext() {
        return next;
    }
}
