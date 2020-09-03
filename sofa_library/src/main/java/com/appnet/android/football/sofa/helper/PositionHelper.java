package com.appnet.android.football.sofa.helper;

import android.content.res.Resources;

import com.appnet.android.football.sofa.R;

public final class PositionHelper {
    public static String getPosition(Resources res, String position) {
        if ("D".equals(position)) {
            return res.getString(R.string.position_defender);
        } else if ("G".equals(position)) {
            return res.getString(R.string.position_goalkeeper);
        } else if ("M".equals(position)) {
            return res.getString(R.string.position_midfielder);
        } else if ("F".equals(position)) {
            return res.getString(R.string.position_forward);
        }
        return position;
    }

    public static String getPreferFoot(Resources res, String foot) {
        if ("Left".equalsIgnoreCase(foot)) {
            return res.getString(R.string.player_preferred_left_foot);
        } else if ("Right".equals(foot)) {
            return res.getString(R.string.player_preferred_right_foot);
        } else if ("Both".equals(foot)) {
            return res.getString(R.string.player_preferred_both_foot);
        }
        return foot;
    }
}
