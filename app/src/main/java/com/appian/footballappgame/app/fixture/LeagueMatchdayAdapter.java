package com.appian.footballappgame.app.fixture;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import androidx.recyclerview.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.appian.footballappgame.Constant;
import com.appian.footballappgame.R;
import com.appian.footballappgame.app.match.MatchActivity;
import com.appian.footballappgame.app.widget.SectionRecyclerViewAdapter;
import com.appian.footballappgame.app.widget.SectionWrapper;
import com.appian.footballappgame.util.ImageLoader;
import com.appian.footballappgame.util.Utils;
import com.appnet.android.football.sofa.data.Event;
import com.appnet.android.football.sofa.data.Team;
import com.appnet.android.football.sofa.helper.SofaImageHelper;

import java.util.Date;
import java.util.List;

class LeagueMatchdayAdapter extends SectionRecyclerViewAdapter<RoundEvents, Event, LeagueMatchdayAdapter.GroupHeaderHolder, LeagueMatchdayAdapter.ChildHolder> {
    private Context mContext;

    LeagueMatchdayAdapter(Context context, List<RoundEvents> data) {
        super(data);
        mContext = context;
    }

    @Override
    public void onBindSectionViewHolder(GroupHeaderHolder sectionViewHolder, int sectionPosition, RoundEvents section) {
        Resources res = mContext.getResources();
        if (TextUtils.isEmpty(section.getRound().getName())) {
            sectionViewHolder.TvGroup.setText(res.getString(R.string.league_fixtures_round, section.getRound().getRound()));
        } else {
            sectionViewHolder.TvGroup.setText(section.getRound().getName());
        }
    }

    @Override
    public void onBindChildViewHolder(ChildHolder holder, int sectionPosition, int childPosition, final Event item) {
        Date date = new Date(item.getStartTimestamp());
        holder.TvDate.setText(Utils.formatWeekTime(mContext, item.getStartTimestamp()));
        holder.TvTime.setText(Utils.formatDateMonthYear(date));


        Team homeTeam = item.getHomeTeam();
        if (homeTeam != null) {
            holder.TvHomeTeamName.setText(homeTeam.getName());
            ImageLoader.displayImage(SofaImageHelper.getSofaImgTeam(homeTeam.getId()), holder.ImgHomeTeamLogo);
        }
        Team awayTeam = item.getAwayTeam();
        if (awayTeam != null) {
            holder.TvAwayTeamName.setText(awayTeam.getName());
            ImageLoader.displayImage(SofaImageHelper.getSofaImgTeam(awayTeam.getId()), holder.ImgAwayTeamLogo);
        }

        String status = (item.getStatus() != null) ? item.getStatus().getType() : "";
        if (status != null && !Constant.SOFA_MATCH_STATUS_NOT_STARTED.equalsIgnoreCase(status)
                && !Constant.SOFA_MATCH_STATUS_CANCELED.equalsIgnoreCase(status)
                && !Constant.SOFA_MATCH_STATUS_POSTPONED.equalsIgnoreCase(status)) {
            holder.TvHomeTeamGoal.setText(String.valueOf(item.getCurrentHomeScore()));
            holder.TvAwayTeamGoal.setText(String.valueOf(item.getCurrentAwayScore()));
            holder.LlFixtureDetailGoals.setVisibility(View.VISIBLE);
            holder.RlTimeDate.setVisibility(View.GONE);
            holder.RlTimeStt.setVisibility(View.GONE);
            if (item.getCurrentHomeScore() > item.getCurrentAwayScore()) {
                holder.TvHomeTeamGoal.setTypeface(holder.TvHomeTeamGoal.getTypeface(), Typeface.BOLD);
                holder.TvHomeTeamName.setTypeface(holder.TvHomeTeamName.getTypeface(), Typeface.BOLD);
                holder.TvAwayTeamGoal.setTypeface(holder.TvAwayTeamGoal.getTypeface(), Typeface.NORMAL);
                holder.TvAwayTeamName.setTypeface(holder.TvAwayTeamName.getTypeface(), Typeface.NORMAL);
            } else if (item.getCurrentHomeScore() < item.getCurrentAwayScore()) {
                holder.TvHomeTeamGoal.setTypeface(holder.TvHomeTeamGoal.getTypeface(), Typeface.NORMAL);
                holder.TvHomeTeamName.setTypeface(holder.TvHomeTeamName.getTypeface(), Typeface.NORMAL);
                holder.TvAwayTeamGoal.setTypeface(holder.TvHomeTeamGoal.getTypeface(), Typeface.BOLD);
                holder.TvAwayTeamName.setTypeface(holder.TvAwayTeamName.getTypeface(), Typeface.BOLD);
            } else {
                holder.TvHomeTeamName.setTypeface(holder.TvHomeTeamName.getTypeface(), Typeface.NORMAL);
                holder.TvHomeTeamGoal.setTypeface(holder.TvHomeTeamGoal.getTypeface(), Typeface.NORMAL);
                holder.TvAwayTeamName.setTypeface(holder.TvAwayTeamName.getTypeface(), Typeface.NORMAL);
                holder.TvAwayTeamGoal.setTypeface(holder.TvHomeTeamGoal.getTypeface(), Typeface.NORMAL);
            }
        } else if (Constant.SOFA_MATCH_STATUS_CANCELED.equalsIgnoreCase(status)
                || Constant.SOFA_MATCH_STATUS_POSTPONED.equalsIgnoreCase(status)) {
            holder.LlFixtureDetailGoals.setVisibility(View.GONE);
            holder.RlTimeDate.setVisibility(View.GONE);
            holder.RlTimeStt.setVisibility(View.VISIBLE);
            holder.TvStt.setText(mContext.getResources().getString(R.string.cancel_match));

        } else {
            holder.LlFixtureDetailGoals.setVisibility(View.GONE);
            holder.RlTimeDate.setVisibility(View.VISIBLE);
            holder.RlTimeStt.setVisibility(View.GONE);
            holder.TvHomeTeamGoal.setText("");
            holder.TvAwayTeamGoal.setText("");
            holder.TvHomeTeamName.setTypeface(holder.TvHomeTeamName.getTypeface(), Typeface.NORMAL);
            holder.TvHomeTeamGoal.setTypeface(holder.TvHomeTeamGoal.getTypeface(), Typeface.NORMAL);
            holder.TvAwayTeamName.setTypeface(holder.TvAwayTeamName.getTypeface(), Typeface.NORMAL);
            holder.TvAwayTeamGoal.setTypeface(holder.TvHomeTeamGoal.getTypeface(), Typeface.NORMAL);
        }
        int color = (Constant.SOFA_MATCH_STATUS_IN_PROGRESS.equalsIgnoreCase(status)) ? R.drawable.circle_red : R.drawable.circle_black;
        holder.TvHomeTeamGoal.setBackgroundResource(color);
        holder.TvAwayTeamGoal.setBackgroundResource(color);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, MatchActivity.class);
                intent.putExtra(Constant.KEY_SOFA_MATCH_ID, item.getId());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public GroupHeaderHolder onCreateSectionViewHolder(ViewGroup sectionViewGroup, int viewType) {
        View header = LayoutInflater.from(mContext).inflate(R.layout.item_league_fixtures_header, sectionViewGroup, false);
        return new GroupHeaderHolder(header);
    }

    @Override
    public ChildHolder onCreateChildViewHolder(ViewGroup childViewGroup, int viewType) {
        View child = LayoutInflater.from(mContext).inflate(R.layout.item_league_fixtures_round, childViewGroup, false);
        return new ChildHolder(child);
    }

    int getInitPosition() {
        int position;
        int size = getItemCount();
        for (position = 0; position < size; position++) {
            SectionWrapper<RoundEvents, Event> sectionWrapper = getItem(position);
            Event child = sectionWrapper.getChild();
            String type = "";
            if(child != null && child.getStatus() != null) {
                type = child.getStatus().getType();
            }
            if (Constant.SOFA_MATCH_STATUS_IN_PROGRESS.equalsIgnoreCase(type)
                    || Constant.SOFA_MATCH_STATUS_NOT_STARTED.equalsIgnoreCase(type)) {
                break;
            }
        }
        position = (position > 0) ? position - 1 : position;
        return position;
    }

    static class ChildHolder extends RecyclerView.ViewHolder {
        TextView TvDate;
        TextView TvTime;
        TextView TvHomeTeamName;
        ImageView ImgHomeTeamLogo;
        TextView TvHomeTeamGoal;
        TextView TvAwayTeamName;
        ImageView ImgAwayTeamLogo;
        TextView TvAwayTeamGoal;
        LinearLayout LlFixtureDetailGoals;
        RelativeLayout RlTimeDate;
        RelativeLayout RlTimeStt;
        TextView TvStt;

        ChildHolder(View view) {
            super(view);
            TvDate = view.findViewById(R.id.tv_fixture_date);
            TvTime = view.findViewById(R.id.tv_fixture_time);
            TvHomeTeamName = view.findViewById(R.id.tv_fixture_home_team_name);
            ImgHomeTeamLogo = view.findViewById(R.id.img_fixture_home_team_logo);
            TvHomeTeamGoal = view.findViewById(R.id.tv_fixture_home_team_goal);
            TvAwayTeamName = view.findViewById(R.id.tv_fixture_away_team_name);
            ImgAwayTeamLogo = view.findViewById(R.id.img_fixture_away_team_logo);
            TvAwayTeamGoal = view.findViewById(R.id.tv_fixture_away_team_goal);
            LlFixtureDetailGoals = view.findViewById(R.id.ll_fixture_detail_goals);
            RlTimeDate = view.findViewById(R.id.rl_time_date);
            RlTimeStt = view.findViewById(R.id.rl_time_stt);
            TvStt = view.findViewById(R.id.tv_fixture_stt);
        }
    }

    static class GroupHeaderHolder extends RecyclerView.ViewHolder {
        TextView TvGroup;

        GroupHeaderHolder(View view) {
            super(view);
            this.TvGroup = view.findViewById(R.id.tv_league_fixtures_group_name);
        }
    }
}
