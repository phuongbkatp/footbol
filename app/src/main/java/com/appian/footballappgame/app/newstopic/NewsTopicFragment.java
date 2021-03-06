package com.appian.footballappgame.app.newstopic;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.View;

import com.appian.footballappgame.R;
import com.appian.footballappgame.app.BaseFragment;
import com.appian.footballappgame.app.ToolbarViewListener;
import com.appian.footballappgame.app.adapter.AdapterViewPager;
import com.appian.footballappgame.app.news.NewsFragment;
import com.appian.footballappgame.app.news.presenter.ListNewsPresenter;
import com.appian.footballappgame.app.news.view.ListNewsView;
import com.appian.footballappgame.data.app.AppConfig;
import com.appian.footballappgame.data.interactor.NewsInteractor;
import com.appnet.android.football.fbvn.data.NewsAuto;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

public class NewsTopicFragment extends BaseFragment implements ListNewsView {
    private ToolbarViewListener mToolbar;

    private ListNewsPresenter mListNewsPresenter;

    private List<Fragment> mTopicFragments;
    private AdapterViewPager mNewsAdapterViewPager;
    private AdapterViewPager mTopicAdapterViewPager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Fragment> fList = new ArrayList<>();
        fList.add(NewsFragment.newInstance(ListNewsPresenter.TYPE_APP));
        fList.add(NewsFragment.newInstance(ListNewsPresenter.TYPE_APP));
        fList.add(NewsFragment.newInstance(ListNewsPresenter.TYPE_APP));
        mNewsAdapterViewPager = new AdapterViewPager(getChildFragmentManager(), fList);
        mTopicFragments = new ArrayList<>();
        mTopicAdapterViewPager = new AdapterViewPager(getChildFragmentManager(), mTopicFragments);
        mListNewsPresenter = new ListNewsPresenter(new NewsInteractor());
        mListNewsPresenter.attachView(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ToolbarViewListener) {
            mToolbar = (ToolbarViewListener) context;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout tabHost = view.findViewById(R.id.materialTabHost);
        ViewPager topicViewPager = view.findViewById(R.id.viewpagerBanner);
        CirclePageIndicator indicator = view.findViewById(R.id.indicator);
        ViewPager newsViewPager = view.findViewById(R.id.viewpager);

        newsViewPager.setAdapter(mNewsAdapterViewPager);
        newsViewPager.setOffscreenPageLimit(3);

        tabHost.setupWithViewPager(newsViewPager);
        Context context = getContext();
        AppConfig appConfig = AppConfig.getInstance();
        TabLayout.Tab tab0 = tabHost.getTabAt(0);
        if(tab0 != null) {
            tab0.setText("");
        }
        TabLayout.Tab tab1 = tabHost.getTabAt(1);
        if(tab1 != null) {
            tab1.setText("");
        }
        TabLayout.Tab tab2 = tabHost.getTabAt(2);
        if(tab2 != null) {
            tab2.setText("");
        }
        topicViewPager.setAdapter(mTopicAdapterViewPager);
        indicator.setViewPager(topicViewPager);

        setTitle();
    }

    @Override
    protected int getLayout() {
        return R.layout.news_topic_layout;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mListNewsPresenter.detachView();
    }

    private void setTitle() {
        if (mToolbar != null) {
            mToolbar.changeToolbarTitle(getString(R.string.news_topic_menu));
        }
    }

    @Override
    public void showListNews(List<NewsAuto> data) {
        if(data == null) {
            return;
        }
/*        for (NewsAuto news : data) {
            HeadNewsFragment fragment = HeadNewsFragment.newInstance(news.getId(), news.getTitle(),
                    news.getThumbnail(), news.getCreatedAt(), news.getCommentCount());
            mTopicFragments.add(fragment);
        }*/
        mTopicAdapterViewPager.notifyDataSetChanged();
    }

    @Override
    public void onLoadListNewsFail() {

    }
}
