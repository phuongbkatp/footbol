package com.appian.footballappgame.app.table;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.appian.footballappgame.R;

class GroupHeaderHolder extends RecyclerView.ViewHolder {
    TextView TvGroup;

    GroupHeaderHolder(View view) {
        super(view);
        this.TvGroup = view.findViewById(R.id.tvGroupName);
    }
}
