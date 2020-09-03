package com.appnet.android.football.fbvn.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailNewsDataAuto {
    @SerializedName("data")
    @Expose
    private DetailNewsAuto data;

    @SerializedName("status")
    @Expose
    private int status;

    public DetailNewsAuto getData() {
        return data;
    }
    public int getStatus() {return status;}
}
