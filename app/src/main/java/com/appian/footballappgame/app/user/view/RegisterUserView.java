package com.appian.footballappgame.app.user.view;

import com.appnet.android.football.fbvn.data.SignInAccount;

public interface RegisterUserView {
    void registerSuccess(SignInAccount data);
    void registerFail();
}
