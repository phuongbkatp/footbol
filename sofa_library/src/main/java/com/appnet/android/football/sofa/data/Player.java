package com.appnet.android.football.sofa.data;

public class Player extends Person {
    private Team team;
    private int shirtNumber;
    private String position;
    private int height;
    private String preferredFoot;
    private String nationality;
    private long dateOfBirthTimestamp;
    private long contractUntilTimestamp;
    private String marketValueCurrency;
    private String flag;
    private long marketValue;
    private int age;

    public Team getTeam() {
        return team;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public String getPosition() {
        return position;
    }

    public int getHeight() {
        return height;
    }

    public String getPreferredFoot() {
        return preferredFoot;
    }

    public String getNationality() {
        return nationality;
    }

    public long getDateOfBirthTimestamp() {
        return dateOfBirthTimestamp*1000;
    }

    public long getContractUntilTimestamp() {
        return contractUntilTimestamp*1000;
    }

    public String getMarketValueCurrency() {
        return marketValueCurrency;
    }

    public String getFlag() {
        return flag;
    }

    public long getMarketValue() {
        return marketValue;
    }

    public int getAge() {
        return age;
    }
}
