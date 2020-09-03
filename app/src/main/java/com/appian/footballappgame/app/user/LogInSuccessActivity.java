package com.appian.footballappgame.app.user;

import android.os.Bundle;
import android.view.View;

import com.appian.footballappgame.R;
import com.appian.footballappgame.app.BaseActivity;
import com.appian.footballappgame.util.SharedPrefs;

public class LogInSuccessActivity extends BaseActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        View btnLoginSuccess = findViewById(R.id.complete_login);
        btnLoginSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPrefs.getInstance().put("isLogin", true);
                finish();
            }
        });
    }

}