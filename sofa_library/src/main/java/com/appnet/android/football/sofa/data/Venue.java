package com.appnet.android.football.sofa.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Venue {
    @SerializedName("stadium")
    @Expose
    private Stadium stadium;
    private City city;
    private int id;

    public Stadium getStadium() {
        return stadium;
    }

    public City getCity() {
        return city;
    }

    public int getId() {
        return id;
    }

    public String getNameStadium() {
        if (stadium != null) {
            return stadium.getName();
        }
        return "";
    }
}