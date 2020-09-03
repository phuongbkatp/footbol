package com.appnet.android.football.sofa.data;

public class Odds {
    private String americanValue;
    private int change;
    private String decimalValue;
    private String fractionalValue;

    public String getDecimalValue() {
        return this.decimalValue;
    }

    public String getFractionalValue() {
        return this.fractionalValue;
    }

    public String getAmericanValue() {
        return this.americanValue;
    }

    public int getChange() {
        return this.change;
    }
}