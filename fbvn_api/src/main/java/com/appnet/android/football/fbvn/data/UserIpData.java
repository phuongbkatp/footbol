package com.appnet.android.football.fbvn.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserIpData {
    @SerializedName("data")
    @Expose
    private UserIp data;

    @SerializedName("status")
    @Expose
    private int status;

    public UserIp getData() {
        return data;
    }

    public int getStatus() {
        return status;
    }
}
