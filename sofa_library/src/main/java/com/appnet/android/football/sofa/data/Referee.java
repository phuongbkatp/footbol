package com.appnet.android.football.sofa.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Referee {
    @SerializedName("name")
    @Expose
    private String name;

    public String getName() {
        return name;
    }
}
