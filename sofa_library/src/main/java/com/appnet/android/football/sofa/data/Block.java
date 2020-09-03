package com.appnet.android.football.sofa.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Block implements Comparable<Block>{
    @SerializedName("id")
    @Expose
    private int id;
    private int blockId;
    private boolean finished;
    private int matchesInRound;
    private int order;
    private String homeTeamScore;
    private String awayTeamScore;
    private List<Participant> participants;
    private List<Integer> events;

    @Override
    public int compareTo(Block object) {
        if (order < object.order)
            return -1;
        else if (order > object.order)
            return 1;
        else
            return 0;
    }

    public int getId() {
        return id;
    }

    public int getBlockId() {
        return blockId;
    }

    public boolean isFinished() {
        return finished;
    }

    public int getMatchesInRound() {
        return matchesInRound;
    }

    public int getOrder() {
        return order;
    }

    public String getHomeTeamScore() {
        return homeTeamScore;
    }

    public String getAwayTeamScore() {
        return awayTeamScore;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public List<Integer> getEvents() {
        return events;
    }
}
