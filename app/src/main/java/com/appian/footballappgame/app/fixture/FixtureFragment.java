package com.appian.footballappgame.app.fixture;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.appian.footballappgame.R;
import com.appian.footballappgame.app.BaseStateFragment;
import com.appian.footballappgame.app.StateFragment;
import com.appian.footballappgame.app.fixture.presenter.FixturesPresenter;
import com.appian.footballappgame.app.fixture.view.FixturesView;
import com.appian.footballappgame.app.league.OnLeagueUpdatedListener;
import com.appian.footballappgame.data.interactor.LeagueInteractor;
import com.appnet.android.football.sofa.data.Event;
import com.appnet.android.football.sofa.data.GameTournament;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FixtureFragment extends BaseStateFragment implements OnLeagueUpdatedListener,
        SwipeRefreshLayout.OnRefreshListener, FixturesView {
    private RecyclerView mLvFixtures;
    private SwipeRefreshLayout mRefreshLayout;
    private LeagueFixturesAdapter mFixtureAdapter;
    private List<RoundEvents> mFixtures;

    private int mLeagueId;
    private int mSeasonId;
    private int mTeamId;

    private FixturesPresenter mFixturesPresenter;

    public static FixtureFragment newInstance(int leagueId, int seasonId, int teamId, StateFragment stateFragment) {
        FixtureFragment fragment = new FixtureFragment();
        Bundle args = new Bundle();
        args.putInt("league_id", leagueId);
        args.putInt("season_id", seasonId);
        args.putInt("team_id", teamId);
        fragment.setArguments(args);
        fragment.setStateFragment(stateFragment);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_fixture;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFixtures = new ArrayList<>();
        mFixtureAdapter = new LeagueFixturesAdapter(getContext(), mFixtures);
        Bundle args = getArguments();
        if (args != null) {
            mLeagueId = args.getInt("league_id");
            mSeasonId = args.getInt("season_id");
            mTeamId = args.getInt("team_id");
        }
        mFixturesPresenter = new FixturesPresenter(new LeagueInteractor());
        mFixturesPresenter.attachView(this);
        loadFixtures();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLvFixtures = view.findViewById(R.id.lv_fixtures);
        mRefreshLayout = view.findViewById(R.id.swipe_refresh);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mRefreshLayout.setRefreshing(false);
        mLvFixtures.setLayoutManager(new LinearLayoutManager(getActivity()));
        mLvFixtures.setAdapter(mFixtureAdapter);
    }

    private void loadFixtures() {
        if (mLeagueId == 0 && mSeasonId == 0) {
            return;
        }
        showLoading(true);
        mFixturesPresenter.loadFixtures(mLeagueId, mSeasonId);
    }

    private void filterTeam(List<GameTournament> tournaments) {
        mFixtures.clear();
        if (mTeamId > 0) {
            Iterator<GameTournament> itp = tournaments.listIterator();
            while (itp.hasNext()) {
                GameTournament tournament = itp.next();
                List<Event> events = tournament.getEvents();
                for (Iterator<Event> it = events.listIterator(); it.hasNext(); ) {
                    Event event = it.next();
                    if (event.getHomeTeam().getId() != mTeamId && event.getAwayTeam().getId() != mTeamId) {
                        it.remove();
                    }
                }
                if (events.size() == 0) {
                    itp.remove();
                }
            }

        }
        mFixtures.addAll(RoundEvents.valueOf(tournaments));
        mFixtureAdapter.notifyDataChanged();
        mLvFixtures.scrollToPosition(mFixtureAdapter.getInitPosition());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mFixturesPresenter.detachView();
    }

    @Override
    public void onLeagueUpdated(int leagueId, int seasonId) {
        mSeasonId = seasonId;
        mLeagueId = leagueId;
        loadFixtures();
    }

    @Override
    public void onRefresh() {
        loadFixtures();
    }

    @Override
    public void showFixtures(List<GameTournament> data) {
        showLoading(false);
        if (data == null) {
            return;
        }
        mFixtures.clear();
        filterTeam(data);
    }

    @Override
    public void onLoadFixturesFail() {
        showLoading(false);
    }

    private void showLoading(boolean isLoading) {
        if (getView() != null) {
            mRefreshLayout.setRefreshing(isLoading);
        }
    }
}
