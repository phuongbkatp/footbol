package com.appnet.android.football.fbvn.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MetaDetailNewsAuto {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("siteName")
    @Expose
    private String siteName;
    @SerializedName("createdTime")
    @Expose
    private long createdTime;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("video")
    @Expose
    private String video;

    public String getVideo() {
        return video;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSiteName() {
        return siteName;
    }

    public long getCreatedTime() {
        return createdTime * 1000;
    }

    public String getLink() {
        return link;
    }

    public String getImage() {
        return image;
    }


}
