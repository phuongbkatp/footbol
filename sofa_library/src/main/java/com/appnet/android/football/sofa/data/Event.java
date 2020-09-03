package com.appnet.android.football.sofa.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("homeTeam")
    @Expose
    private Team homeTeam;

    @SerializedName("awayTeam")
    @Expose
    private Team awayTeam;

    @SerializedName("venue")
    @Expose
    private Venue venue;

    @SerializedName("homeScore")
    @Expose
    private Score homeScore;

    @SerializedName("awayScore")
    @Expose
    private Score awayScore;

    @SerializedName("bestHomeTeamPlayer")
    @Expose
    private BestPlayer bestHomeTeamPlayer;

    @SerializedName("bestAwayTeamPlayer")
    @Expose
    private BestPlayer bestAwayTeamPlayer;

    @SerializedName("startTimestamp")
    @Expose
    private long startTimestamp;

    @SerializedName("startTime")
    @Expose
    private String startTime;

    @SerializedName("formatedStartDate")
    @Expose
    private String formatedStartDate;

    @SerializedName("roundInfo")
    @Expose
    private Round roundInfo;

    @SerializedName("status")
    @Expose
    private Status status;

    private String statusDescription;
    @SerializedName("referee")
    @Expose
    private Referee referee;

    private transient Tournament tournament;

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public Venue getVenue() {
        return venue;
    }

    public Score getHomeScore() {
        return homeScore;
    }

    public Score getAwayScore() {
        return awayScore;
    }

    public BestPlayer getBestHomeTeamPlayer() {
        return bestHomeTeamPlayer;
    }

    public BestPlayer getBestAwayTeamPlayer() {
        return bestAwayTeamPlayer;
    }

    public long getStartTimestamp() {
        return startTimestamp*1000;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getFormatedStartDate() {
        return formatedStartDate;
    }

    public Round getRoundInfo() {
        return roundInfo;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public String getNameStadium() {
        if(venue == null) {
            return "";
        }
        return venue.getNameStadium();
    }

    public int getCurrentHomeScore() {
        if(homeScore == null) {
            return 0;
        }
        return homeScore.getCurrent();
    }

    public int getCurrentAwayScore() {
        if(awayScore == null) {
            return 0;
        }
        return awayScore.getCurrent();
    }

    public Tournament getTournament() {
        return tournament;
    }

    void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public Referee getReferee() {
        return referee;
    }

    public String getRefereeName() {
        if(referee != null) {
            return referee.getName();
        }
        return "";
    }
}
