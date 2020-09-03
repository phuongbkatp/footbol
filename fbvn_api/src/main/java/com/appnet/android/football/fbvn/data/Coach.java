package com.appnet.android.football.fbvn.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coach {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("national")
    @Expose
    private String national;
    @SerializedName("birth_of_date")
    @Expose
    private String birthDay;
    @SerializedName("avatar_src")
    @Expose
    private String avatar;
    @SerializedName("sofa_id")
    @Expose
    private int sofaId;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNational() {
        return national;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getAvatar() {
        return avatar;
    }

    public int getSofaId() {
        return sofaId;
    }
}
