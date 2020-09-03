package com.appnet.android.football.sofa.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status {
    @SerializedName("venue")
    @Expose
    private int code;
    @SerializedName("type")
    @Expose
    private String type;

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }
}
