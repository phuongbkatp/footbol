package com.appian.footballappgame.app;

import androidx.fragment.app.Fragment;

public interface StateFragment {
    void onCreated(Fragment fragment);
    void onDestroyed(Fragment fragment);
}
