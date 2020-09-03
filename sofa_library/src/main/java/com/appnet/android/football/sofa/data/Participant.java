package com.appnet.android.football.sofa.data;

public class Participant implements Comparable<Participant> {
    private int id;
    private Team team;
    private boolean winner;
    private int order;

    @Override
    public int compareTo(Participant object) {
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

    public Team getTeam() {
        return team;
    }

    public boolean isWinner() {
        return winner;
    }

    public int getOrder() {
        return order;
    }
}
