package com.appian.footballappgame.app.adapter;

import java.util.List;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class AdapterViewPager extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments;
    public AdapterViewPager(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public int getCount() {
        return this.mFragments.size();
    }
    @Override
    public Fragment getItem(int position) {
        return this.mFragments.get(position);
    }
}