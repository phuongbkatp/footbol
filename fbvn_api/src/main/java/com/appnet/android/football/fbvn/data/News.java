package com.appnet.android.football.fbvn.data;

import android.text.TextUtils;

public class News {
    private int id;
    private String title;
    private String description;
    private String source;
    private int layout_type;
    private String object_type;
    private String object_id;
    private String language;
    private long created_at;
    private String content;
    private String featured_image;
    private int comment_count;
    private String type;
    private String url;
    private String thumbnail;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSource() {
        return source;
    }

    public int getLayoutType() {
        return layout_type;
    }

    public String getObjectType() {
        return object_type;
    }

    public String getObjectId() {
        return object_id;
    }

    public String getLanguage() {
        return language;
    }

    public long getCreatedAt() {
        return created_at*1000;
    }

    public String getThumbnail() {
        if(TextUtils.isEmpty(thumbnail)) {
            return featured_image;
        }
        return thumbnail;
    }

    public String getContent() {
        return content;
    }

    public int getCommentCount() {
        return comment_count;
    }

    public boolean isVideoType() {
        return "video".equals(type);
    }

    public String getUrl() {
        return url;
    }

}
