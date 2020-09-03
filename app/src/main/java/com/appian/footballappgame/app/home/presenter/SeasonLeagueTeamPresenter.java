package com.appian.footballappgame.app.home.presenter;

import com.appian.footballappgame.app.BasePresenter;
import com.appian.footballappgame.app.home.view.SeasonLeagueTeamView;
import com.appian.footballappgame.data.interactor.LeagueInteractor;
import com.appian.footballappgame.data.interactor.OnResponseListener;
import com.appnet.android.football.fbvn.data.LeagueSeason;

import java.util.List;

public class SeasonLeagueTeamPresenter extends BasePresenter<SeasonLeagueTeamView> implements OnResponseListener<List<LeagueSeason>> {
    private final LeagueInteractor mInteractor;

    public SeasonLeagueTeamPresenter() {
        mInteractor = new LeagueInteractor();
    }

    public SeasonLeagueTeamPresenter(LeagueInteractor interactor) {
        mInteractor = interactor;
    }

    public void loadSeasonLeaguesByTeam(int seasonId, int teamId) {
        mInteractor.loadSeasonLeaguesByTeam(seasonId, teamId, this);
    }

    public void onSuccess(List<LeagueSeason> data) {
        if(getView() != null) {
            getView().showSeasonLeagueTeam(data);
        }
    }

    @Override
    public void onFailure(String error) {

    }
}
