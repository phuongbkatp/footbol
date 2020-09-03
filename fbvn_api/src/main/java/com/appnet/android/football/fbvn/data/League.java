package com.appnet.android.football.fbvn.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class League {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("logo_src")
    @Expose
    private String logo;
    @SerializedName("sofa_id")
    @Expose
    private int sofaId;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }

    public int getSofaId() {
        return sofaId;
    }
}
