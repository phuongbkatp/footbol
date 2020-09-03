package com.appian.footballappgame.app.match.statistics;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.appian.footballappgame.R;

public class StatisticItemHolder extends RecyclerView.ViewHolder {
    TextView TvHome;
    TextView TvName;
    TextView TvAway;

    StatisticItemHolder(View view) {
        super(view);
        this.TvHome = view.findViewById(R.id.tv_statistic_home);
        this.TvName = view.findViewById(R.id.tv_statistic_name);
        this.TvAway = view.findViewById(R.id.tv_statistic_away);
    }

}
