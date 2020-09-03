package com.appnet.android.football.sofa.data;

public class TableRow {
    private Team team;
    private String points;
    private String position;
    private TableField totalFields;
    private Promotion promotion;

    public Team getTeam() {
        return team;
    }

    public String getPoints() {
        return points;
    }

    public TableField getTotalFields() {
        return totalFields;
    }

    public String getPosition() {
        return position;
    }

    public Promotion getPromotion() {
        return promotion;
    }
}
