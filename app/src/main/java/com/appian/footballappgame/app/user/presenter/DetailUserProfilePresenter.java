package com.appian.footballappgame.app.user.presenter;

import com.appian.footballappgame.app.BasePresenter;
import com.appian.footballappgame.app.user.view.DetailUserProfileView;
import com.appian.footballappgame.data.interactor.OnResponseListener;
import com.appian.footballappgame.data.interactor.UserInteractor;
import com.appnet.android.football.fbvn.data.AccountProfile;

public class DetailUserProfilePresenter extends BasePresenter<DetailUserProfileView> implements OnResponseListener<AccountProfile> {
    private final UserInteractor mInteractor;

    public DetailUserProfilePresenter(UserInteractor interactor) {
        mInteractor = interactor;
    }

    public void loadDetailUserProfile(String authorization) {
        mInteractor.loadUserProfile(authorization, this);
    }

    @Override
    public void onSuccess(AccountProfile data) {
        if(getView() == null) {
            return;
        }
        getView().showUserProfile(data);
    }

    @Override
    public void onFailure(String error) {

    }
}
