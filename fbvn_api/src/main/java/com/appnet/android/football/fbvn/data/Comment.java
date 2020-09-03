package com.appnet.android.football.fbvn.data;

public class Comment {
    private int id;
    private String object_type;
    private int object_id;
    private long created_at;
    private String content;
    private User user;
    private UserProfile user_profile;

    public int getId() {
        return id;
    }

    public String getObjectType() {
        return object_type;
    }

    public int getObjectId() {
        return object_id;
    }

    public long getCreatedAt() {
        return created_at*1000;
    }

    public User getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    public UserProfile getUserProfile() {
        return user_profile;
    }
}
