package com.appian.footballappgame.app.setting;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.appian.footballappgame.MainApplication;
import com.appian.footballappgame.R;
import com.appian.footballappgame.app.ToolbarViewListener;
import com.appian.footballappgame.data.app.AppConfig;
import com.appian.footballappgame.data.app.Language;
import com.appian.footballappgame.data.app.helper.NotificationHelper;
import com.appian.footballappgame.service.app.AppHelper;
import com.appian.footballappgame.util.CacheHelper;
import com.appian.footballappgame.util.ViewHelper;

public class SettingsFragment extends PreferenceFragment {
    private ToolbarViewListener mToolBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        updateTitle();
        initSetting();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ToolbarViewListener) {
            mToolBar = (ToolbarViewListener) context;
        }
    }

    private void updateTitle() {
        if (mToolBar != null) {
            mToolBar.changeToolbarTitle(getResources().getString(R.string.setting_menu));
        }
    }

    private void initSetting() {
        // News
        Preference newsPref = findPreference(NotificationHelper.KEY_BREAK_NEWS);
        newsPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                boolean value = Boolean.TRUE.equals(o);
                AppHelper.followNews(getActivity(), value);
                return true;
            }
        });
        // Match event
        Preference matchPref = findPreference(NotificationHelper.KEY_MATCH_EVENT);
        matchPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                boolean value = Boolean.TRUE.equals(o);
                AppHelper.followEventMatch(getActivity(), value);
                return true;
            }
        });
        // Language
        ListPreference langPref = (ListPreference) findPreference(NotificationHelper.KEY_LANGUAGE_SETTING);
        String lang = Language.getLanguage(getActivity());
        langPref.setValue(lang);
        langPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                AppHelper.changeLanguage(getActivity(), o.toString());
                ViewHelper.restartApp(getActivity());
                return true;
            }
        });
        // Privacy and policy
        // News
        Preference policyPref = findPreference(NotificationHelper.KEY_PRIVACY_POLICY);
        policyPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                AppConfig config = AppConfig.getInstance();
                openWebPage(config.getPolicyUrl());
                return true;
            }
        });

        Preference rateAppPref = findPreference(NotificationHelper.KEY_RATE_SETTING);
        rateAppPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Uri uri = Uri.parse("market://details?id=" + getActivity().getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                int flags = Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    flags |= Intent.FLAG_ACTIVITY_NEW_DOCUMENT;
                }
                goToMarket.addFlags(flags);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getActivity().getPackageName())));
                }
                return true;
            }
        });

        Preference clearCachePref = findPreference(NotificationHelper.KEY_CLEAR_CACHE);
        clearCachePref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                showClearCacheDialog();
                return true;
            }
        });
    }

    private void openWebPage(String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Uri webPage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void showClearCacheDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        Resources res = getResources();
        builder.setTitle(res.getString(R.string.cache_setting));
        builder.setMessage(res.getString(R.string.body_confirm_clear_cache_dialog));
        builder.setNegativeButton(R.string.close, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Context context = MainApplication.getApplication().getApplicationContext();
                dialogInterface.dismiss();
                if (CacheHelper.deleteCache(MainApplication.getApplication().getApplicationContext())) {
                    Toast.makeText(context, R.string.clear_cached_data_success, Toast.LENGTH_SHORT).show();
                    ViewHelper.restartApp(context);
                }
            }
        });
        builder.setCancelable(true);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
