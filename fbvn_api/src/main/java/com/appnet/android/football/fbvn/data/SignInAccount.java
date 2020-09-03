package com.appnet.android.football.fbvn.data;

import java.util.List;

public class SignInAccount {
    private User user;
    private List<AccessToken> tokens;
    private UserProfile user_profile;

    public User getUser() {
        return user;
    }

    public AccessToken getToken() {
        if(tokens == null || tokens.isEmpty()) {
            return null;
        }
        return tokens.get(0);
    }

    public UserProfile getUserProfile() {
        return user_profile;
    }
}
