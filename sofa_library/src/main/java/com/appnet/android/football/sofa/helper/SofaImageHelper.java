package com.appnet.android.football.sofa.helper;

public final class SofaImageHelper {
    private static final String SOFA_IMG_PLAYER_URL = "https://www.sofascore.com/images/player/image_";
    private static final String SOFA_IMG_TEAM_URL = "https://www.sofascore.com/images/team-logo/football_";
    private static final String SOFA_IMG_MANAGER_URL = "https://www.sofascore.com/images/manager/";
    private static final String SOFA_LEAGUE_URL = "https://www.sofascore.com/u-tournament/";

    public static String getSofaImgPlayer(int playerId) {
        return SOFA_IMG_PLAYER_URL + playerId + ".png";
    }

    public static String getSofaImgTeam(int teamId) {
        return SOFA_IMG_TEAM_URL + teamId + ".png";
    }

    public static String getSofaImgManager(int managerId) {
        return SOFA_IMG_MANAGER_URL + managerId;
    }

    public static String getSofaImgLeague(int leagueId) {
        return SOFA_LEAGUE_URL + leagueId + "/logo";
    }
}
