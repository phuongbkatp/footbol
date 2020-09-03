package com.appian.footballappgame.app;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;

import com.appian.footballappgame.data.app.Language;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(Language.onAttach(newBase));
    }
}
