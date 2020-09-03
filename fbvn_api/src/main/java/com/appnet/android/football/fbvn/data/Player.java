package com.appnet.android.football.fbvn.data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("short_name")
    @Expose
    private String shortName;
    @SerializedName("avatar_src")
    @Expose
    private String avatar;
    @SerializedName("sofa_id")
    @Expose
    private int sofaId;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("status")
    @Expose
    private String status;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getAvatar() {
        return avatar;
    }

    public int getSofaId() {
        return sofaId;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getHeight() {
        return height;
    }

    public String getStatus() {
        return status;
    }
}
