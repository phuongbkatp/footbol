package com.appian.footballappgame.app.team.presenter;

import com.appian.footballappgame.app.BasePresenter;
import com.appian.footballappgame.app.team.view.TeamSquadView;
import com.appian.footballappgame.data.interactor.OnResponseListener;
import com.appian.footballappgame.data.interactor.TeamInteractor;
import com.appnet.android.football.sofa.data.Player;

import java.util.List;

public class TeamSquadPresenter extends BasePresenter<TeamSquadView> implements OnResponseListener<List<Player>> {
    private final TeamInteractor mInteractor;

    public TeamSquadPresenter() {
        mInteractor = new TeamInteractor();
    }

    public TeamSquadPresenter(TeamInteractor interactor) {
        mInteractor = interactor;
    }

    public void loadTeamSquad(int teamId) {
        if(getView() == null) {
            return;
        }
        mInteractor.loadTeamSquad(teamId, this);
    }

    @Override
    public void onSuccess(List<Player> data) {
        if(getView() != null) {
            getView().showTeamSquad(data);
        }
    }

    @Override
    public void onFailure(String error) {

    }
}
