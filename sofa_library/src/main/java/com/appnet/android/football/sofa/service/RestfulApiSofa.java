package com.appnet.android.football.sofa.service;

import com.appnet.android.football.sofa.data.Bet365Odds;
import com.appnet.android.football.sofa.data.CupTree;
import com.appnet.android.football.sofa.data.EventDetail;
import com.appnet.android.football.sofa.data.Game;
import com.appnet.android.football.sofa.data.Incident;
import com.appnet.android.football.sofa.data.LineupsData;
import com.appnet.android.football.sofa.data.Manager;
import com.appnet.android.football.sofa.data.Performance;
import com.appnet.android.football.sofa.data.Player;
import com.appnet.android.football.sofa.data.Statistic;
import com.appnet.android.football.sofa.data.StatisticsData;
import com.appnet.android.football.sofa.data.TableRowsData;
import com.appnet.android.football.sofa.data.Team;
import com.appnet.android.football.sofa.data.TeamLastNextData;
import com.appnet.android.football.sofa.data.Transfer;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface RestfulApiSofa {
    String BASE_URL =  "https://api.sofascore.com/mobile/v4/";

    @GET("event/{event_id}/details")
    Call<EventDetail> loadMatchDetail(@Path("event_id") int matchId);

    @GET("event/{event_id}/details")
    Call<EventDetail> loadMatchDetail(@Header("Cache-Control") String cacheControl, @Path("event_id") int matchId);

    @GET("event/{event_id}/incidents")
    Call<List<Incident>> loadIncidents(@Path("event_id") int matchId);

    @GET("event/{event_id}/incidents")
    Call<List<Incident>> loadIncidents(@Header("Cache-Control") String cacheControl, @Path("event_id") int matchId);

    @GET("event/{event_id}/lineups")
    Call<LineupsData> loadLineups(@Path("event_id") int matchId);

    @GET("event/{event_id}/statistics")
    Call<StatisticsData> loadStatistics(@Path("event_id") int matchId);

    @GET("event/{event_id}/statistics")
    Call<Statistic> loadMatchStatistics(@Path("event_id") int matchId);

    @GET("event/{event_id}/odds")
    Call<List<Bet365Odds>> loadOdds(@Path("event_id") int matchId);

    @GET("team/{team_id}/details")
    Call<Team> loadTeamDetails(@Path("team_id") int teamId);

    @GET("team/{team_id}/lastnext")
    Call<TeamLastNextData> loadTeamLastNext(@Path("team_id") int teamId);

    @GET("team/{team_id}/players")
    Call<List<Player>> loadSquad(@Path("team_id") int teamId);

    @GET("team/{team_id}/performance")
    Call<List<Performance>> loadTeamPerformance(@Path("team_id") int teamId);

    @GET("unique-tournament/{league_id}/season/{season_id}/standings")
    Call<List<TableRowsData>> loadTournamentStanding(@Path("league_id") int leagueId, @Path("season_id") int seasonId);

    @GET("unique-tournament/{league_id}/season/{season_id}/events")
    Call<Game> loadTournamentFixtures(@Path("league_id") int leagueId, @Path("season_id") int seasonId);

    @GET("player/{player_id}/details")
    Call<Player> loadPlayerDetails(@Path("player_id") int playerId);

    @GET("player/{player_id}/transfer-history")
    Call<List<Transfer>> loadPlayerTransferHistory(@Path("player_id") int playerId);

    @GET("manager/{manager_id}/details")
    Call<Manager> loadManagerDetails(@Path("manager_id") int managerId);

    @GET("unique-tournament/{league_id}/season/{season_id}/cuptree")
    Call<List<CupTree>> loadCupTree(@Path("league_id") int leagueId, @Path("season_id") int seasonId);

    class Factory {
        public static RestfulApiSofa create() {
            return create("https://api.sofascore.com/mobile/v4/");
        }

        public static RestfulApiSofa create(String baseUrl) {
            OkHttpClient client = new OkHttpClient.Builder().build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(RestfulApiSofa.class);
        }
    }
}
