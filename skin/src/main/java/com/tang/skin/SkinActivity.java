package com.tang.skin;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.LayoutInflaterCompat;

public class SkinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LayoutInflaterCompat.setFactory2(LayoutInflater.from(this), this);
        super.onCreate(savedInstanceState);
    }

    private CustomAppCompatViewInflater viewInflater;

    @Nullable
    @Override
    public View onCreateView(@Nullable View parent,
                             @NonNull String name,
                             @NonNull Context context,
                             @NonNull AttributeSet attrs) {
        if (openChangeSkin()) {
            if (viewInflater == null) {
                viewInflater = new CustomAppCompatViewInflater();
            }
            return viewInflater.createView(name, context, attrs);
        }
        return super.onCreateView(parent, name, context, attrs);
    }

    /**
     * @return 是否开启换肤，增加此开关是为了避免开发者误继承此父类，导致未知bug
     */
    protected boolean openChangeSkin() {
        return false;
    }

    protected void setDayNightMode(@AppCompatDelegate.NightMode int mode) {
        if (Build.VERSION.SDK_INT > 21) {
            Looger.e("系统版本大于21");
        }
        getDelegate().setLocalNightMode(mode);
        View decorView = getWindow().getDecorView();
        applyDayNightForView(decorView);
    }

    /**
     * 接口回调View,通知换肤
     */
    private void applyDayNightForView(View view) {
        if (view instanceof ViewsMatch) {
            ((ViewsMatch) view).skinView();
        }

        if (view instanceof ViewGroup) {
            ViewGroup parent = (ViewGroup) view;
            int count = parent.getChildCount();
            for (int i = 0; i < count; i++) {
                applyDayNightForView(parent.getChildAt(i));
            }
        }
    }

}