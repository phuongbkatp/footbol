package com.appnet.android.football.sofa.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Score {
    @SerializedName("current")
    @Expose
    private int current;
    @SerializedName("period1")
    @Expose
    private int period1;
    @SerializedName("normaltime")
    @Expose
    private int normaltime;

    public int getCurrent() {
        return current;
    }

    public int getPeriod1() {
        return period1;
    }

    public int getNormaltime() {
        return normaltime;
    }
}
