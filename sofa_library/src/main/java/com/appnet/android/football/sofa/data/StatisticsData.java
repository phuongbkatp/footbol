package com.appnet.android.football.sofa.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatisticsData {
    @SerializedName("homeTotalShotsOnGoal")
    @Expose
    private int homeTotalShotsOnGoal;
    @SerializedName("homeShotsOnGoal")
    @Expose
    private int homeShotsOnGoal;
    @SerializedName("homeFouls")
    @Expose
    private int homeFouls;

    @SerializedName("homeCornerKicks")
    @Expose
    private int homeCornerKicks;
    @SerializedName("homeOffsides")
    @Expose
    private int homeOffsides;
    @SerializedName("homeBallPossession")
    @Expose
    private int homeBallPossession;
    @SerializedName("homeYellowCards")
    @Expose
    private int homeYellowCards;
    @SerializedName("homeGoalkeeperSaves")
    @Expose
    private int homeGoalkeeperSavers;

    @SerializedName("awayTotalShotsOnGoal")
    @Expose
    private int awayTotalShotsOnGoal;
    @SerializedName("awayShotsOnGoal")
    @Expose
    private int awayShotsOnGoal;
    @SerializedName("awayFouls")
    @Expose
    private int awayFouls;

    @SerializedName("awayCornerKicks")
    @Expose
    private int awayCornerKicks;
    @SerializedName("awayOffsides")
    @Expose
    private int awayOffsides;
    @SerializedName("awayBallPossession")
    @Expose
    private int awayBallPossession;
    @SerializedName("awayYellowCards")
    @Expose
    private int awayYellowCards;
    @SerializedName("awayGoalkeeperSaves")
    @Expose
    private int awayGoalkeeperSavers;

    public int getHomeTotalShotsOnGoal() {
        return homeTotalShotsOnGoal;
    }

    public int getHomeShotsOnGoal() {
        return homeShotsOnGoal;
    }

    public int getHomeFouls() {
        return homeFouls;
    }

    public int getHomeCornerKicks() {
        return homeCornerKicks;
    }

    public int getHomeOffsides() {
        return homeOffsides;
    }

    public int getHomeBallPossession() {
        return homeBallPossession;
    }

    public int getHomeYellowCards() {
        return homeYellowCards;
    }

    public int getHomeGoalkeeperSavers() {
        return homeGoalkeeperSavers;
    }

    public int getAwayTotalShotsOnGoal() {
        return awayTotalShotsOnGoal;
    }

    public int getAwayShotsOnGoal() {
        return awayShotsOnGoal;
    }

    public int getAwayFouls() {
        return awayFouls;
    }

    public int getAwayCornerKicks() {
        return awayCornerKicks;
    }

    public int getAwayOffsides() {
        return awayOffsides;
    }

    public int getAwayBallPossession() {
        return awayBallPossession;
    }

    public int getAwayYellowCards() {
        return awayYellowCards;
    }

    public int getAwayGoalkeeperSavers() {
        return awayGoalkeeperSavers;
    }
}
