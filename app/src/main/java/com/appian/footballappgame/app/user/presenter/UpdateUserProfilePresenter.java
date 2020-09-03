package com.appian.footballappgame.app.user.presenter;

import com.appian.footballappgame.app.BasePresenter;
import com.appian.footballappgame.app.user.view.UpdateUserProfileView;
import com.appian.footballappgame.data.interactor.OnResponseListener;
import com.appian.footballappgame.data.interactor.UserInteractor;
import com.appnet.android.football.fbvn.data.AccountProfile;

public class UpdateUserProfilePresenter extends BasePresenter<UpdateUserProfileView> implements OnResponseListener<AccountProfile> {
    private final UserInteractor mInteractor;

    public UpdateUserProfilePresenter(UserInteractor interactor) {
        mInteractor = interactor;
    }

    public void updateUserProfile(String authorization, String firstName, String lastName, String email, boolean male, String address) {
        mInteractor.updateUserProfile(authorization, firstName, lastName, email, male, address, this);
    }

    @Override
    public void onSuccess(AccountProfile data) {
        if(getView() == null) {
            return;
        }
        getView().updateSuccess(data);
    }

    @Override
    public void onFailure(String error) {
        if(getView() == null) {
            return;
        }
        getView().updateFail();
    }
}
