package com.appian.footballappgame.app.coach.presenter;


import com.appian.footballappgame.app.BasePresenter;
import com.appian.footballappgame.app.coach.view.CoachDetailView;
import com.appian.footballappgame.data.interactor.ManagerInteractor;
import com.appian.footballappgame.data.interactor.OnResponseListener;
import com.appnet.android.football.sofa.data.Manager;

public class CoachDetailPresenter extends BasePresenter<CoachDetailView> implements OnResponseListener<Manager> {
    private final ManagerInteractor mInteractor;

    public CoachDetailPresenter() {
        mInteractor = new ManagerInteractor();
    }

    public CoachDetailPresenter(ManagerInteractor interactor) {
        mInteractor = interactor;
    }

    public void loadCoachDetail(int managerId) {
        if(getView() == null || managerId == 0) {
            return;
        }
        mInteractor.loadManagerDetail(managerId, this);
    }

    @Override
    public void onSuccess(Manager data) {
        if(getView() == null) {
            return;
        }
        getView().showCoachDetail(data);
    }

    @Override
    public void onFailure(String error) {

    }
}
