package com.tang.skin_local;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import com.tang.skin.SkinActivity;

import androidx.appcompat.app.AppCompatDelegate;

public class TestActivity extends SkinActivity {

    @Override
    protected boolean openChangeSkin() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void skin(View view) {
        int uiMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (uiMode) {
            case Configuration.UI_MODE_NIGHT_NO:
                setDayNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case Configuration.UI_MODE_NIGHT_YES:
                setDayNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            default:
                break;
        }
    }

}