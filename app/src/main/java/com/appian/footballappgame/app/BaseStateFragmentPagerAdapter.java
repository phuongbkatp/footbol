package com.appian.footballappgame.app;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseStateFragmentPagerAdapter extends FragmentPagerAdapter implements StateFragment {
    private List<Fragment> mFragments;

    public BaseStateFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<>();
    }

    @Override
    public void onCreated(Fragment fragment) {
        mFragments.add(fragment);
    }

    @Override
    public void onDestroyed(Fragment fragment) {
        mFragments.remove(fragment);
    }

    public List<Fragment> getStateFragments() {
        return mFragments;
    }
}
