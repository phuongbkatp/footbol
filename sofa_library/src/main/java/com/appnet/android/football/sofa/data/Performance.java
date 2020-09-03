package com.appnet.android.football.sofa.data;

public class Performance {
    private int eventId;
    private float points;
    private String winFlag;
    private Opponent opponent;

    public int getEventId() {
        return eventId;
    }

    public float getPoints() {
        return points;
    }

    public String getWinFlag() {
        return winFlag;
    }

    public Opponent getOpponent() {
        return opponent;
    }
}
