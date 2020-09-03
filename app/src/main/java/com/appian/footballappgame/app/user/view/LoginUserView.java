package com.appian.footballappgame.app.user.view;

import com.appnet.android.football.fbvn.data.SignInAccount;

public interface LoginUserView {
    void loginSuccess(SignInAccount data);
    void loginFail();
}
