package com.appian.footballappgame.app.match.statistics;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.appian.footballappgame.R;

public class StatisticGroupHeaderHolder extends RecyclerView.ViewHolder {
    TextView TvGroup;

    StatisticGroupHeaderHolder(View view) {
        super(view);
        this.TvGroup = view.findViewById(R.id.tv_group_name);
    }

}
