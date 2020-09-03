package com.appian.footballappgame.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import android.widget.TextView;

import com.appian.footballappgame.R;
import com.appian.footballappgame.service.notification.NotificationFactory;
import com.appian.footballappgame.util.Utils;

public class SplashActivity extends BaseActivity {
    private static final int SPLASH_TIME_OUT = 3000;
    private Handler mHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_activity);
        TextView tvSplashClaim = findViewById(R.id.tv_splash_claim);
        tvSplashClaim.setText(getResources().getString(R.string.splash_claim, getResources().getString(R.string.team_fc)));

        Utils.initAdmob(getApplicationContext());
        if (getIntent() != null && getIntent().getExtras() != null) {
            boolean notification = NotificationFactory.handleNotification(getApplicationContext(), getIntent().getExtras());
            if(notification) {
                finish();
            } else {
                launchMainScreen();
            }
        } else {
            launchMainScreen();
        }

    }

    private void launchMainScreen() {
        mHandler = new Handler(Looper.getMainLooper());
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
        }
    }
}
