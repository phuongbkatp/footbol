package com.appian.footballappgame.app.match.presenter;

import com.appian.footballappgame.app.BasePresenter;
import com.appian.footballappgame.app.match.view.MatchLineupsView;
import com.appian.footballappgame.data.interactor.MatchInteractor;
import com.appian.footballappgame.data.interactor.OnResponseListener;
import com.appnet.android.football.sofa.data.LineupsData;

public class MatchLineupsPresenter extends BasePresenter<MatchLineupsView> implements OnResponseListener<LineupsData> {
    private final MatchInteractor mInteractor;

    public MatchLineupsPresenter() {
        mInteractor = new MatchInteractor();
    }

    public MatchLineupsPresenter(MatchInteractor interactor) {
        mInteractor = interactor;
    }

    public void loadMatchLineups(int matchId) {
        if (matchId == 0 || getView() == null) {
            return;
        }
        mInteractor.loadLineups(matchId, this);
    }

    @Override
    public void onSuccess(LineupsData data) {
        if (getView() != null) {
            getView().showMatchLineups(data);
        }
    }

    @Override
    public void onFailure(String error) {

    }
}
