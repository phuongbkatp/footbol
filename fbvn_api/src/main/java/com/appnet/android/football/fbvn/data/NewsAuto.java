package com.appnet.android.football.fbvn.data;

import android.text.TextUtils;

public class NewsAuto {
    private String title;
    private String description;
    private String siteName;
    private long createdTime;
    private String link;
    private String image;

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
