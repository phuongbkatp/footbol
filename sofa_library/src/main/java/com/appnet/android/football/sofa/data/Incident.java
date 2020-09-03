package com.appnet.android.football.sofa.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Incident {
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("incidentType")
    @Expose
    private String incidentType;
    @SerializedName("time")
    @Expose
    private int time;
    @SerializedName("addedTime")
    @Expose
    private int addedTime;
    @SerializedName("playerTeam")
    @Expose
    private int playerTeam;
    @SerializedName("player")
    @Expose
    private Person player;
    @SerializedName("playerOut")
    @Expose
    private Person playerOut;
    @SerializedName("playerIn")
    @Expose
    private Person playerIn;
    @SerializedName("assist1")
    @Expose
    private Person assist1;

    @SerializedName("homeScore")
    @Expose
    private int homeScore;
    @SerializedName("awayScore")
    @Expose
    private int awayScore;

    @SerializedName("from")
    @Expose
    private String from;

    @SerializedName("length")
    @Expose
    private int length;
    @SerializedName("missed")
    @Expose
    private int missed;

    @SerializedName("scoringTeam")
    @Expose
    private int scoringTeam;

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public int getTime() {
        return time;
    }

    public int getAddedTime() {
        return addedTime;
    }

    public boolean isHome() {
        return playerTeam == 1;
    }

    public Person getPlayer() {
        return player;
    }

    public Person getPlayerOut() {
        return playerOut;
    }

    public Person getPlayerIn() {
        return playerIn;
    }

    public Person getAssist1() {
        return assist1;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public String getFrom() {
        return from;
    }

    public int getLength() {
        return length;
    }

    public int getMissed() {
        return missed;
    }

    public int getScoringTeam() {
        return scoringTeam;
    }
}
