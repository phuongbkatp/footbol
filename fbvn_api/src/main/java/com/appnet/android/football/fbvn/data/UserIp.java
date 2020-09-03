package com.appnet.android.football.fbvn.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class UserIp {
    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("name")
    @Expose
    private String name;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}