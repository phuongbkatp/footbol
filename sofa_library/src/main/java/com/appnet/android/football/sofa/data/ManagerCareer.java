package com.appnet.android.football.sofa.data;

public class ManagerCareer {
    private Team team;
    private int days;
    private int matches;
    private int wins;
    private int draws;
    private int losses;
    private float averageGoalsScored;
    private float averageGoalsConceded;
    private long startTimestamp;
    private long endTimestamp;
    private transient float pointsPerMatch = 0;

    public Team getTeam() {
        return team;
    }

    public int getDays() {
        return days;
    }

    public int getMatches() {
        return matches;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLosses() {
        return losses;
    }

    public float getAverageGoalsScored() {
        return averageGoalsScored;
    }

    public float getAverageGoalsConceded() {
        return averageGoalsConceded;
    }

    public long getStartTimestamp() {
        return startTimestamp*1000;
    }

    public long getEndTimestamp() {
        return endTimestamp*1000;
    }

    public float getPointsPerMatch() {
        if(matches == 0) {
            return 0;
        }
        if(pointsPerMatch == 0) {
            pointsPerMatch = (3f*wins + draws)/matches;
        }
        return pointsPerMatch;
    }
}
