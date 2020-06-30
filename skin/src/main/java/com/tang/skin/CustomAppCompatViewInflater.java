package com.tang.skin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

/**
 * 作者:  tang
 * 时间： 2020/4/30 0030 下午 5:38
 * 邮箱： 3349913147@qq.com
 * 描述：
 */
public class CustomAppCompatViewInflater {

    final View createView(@NonNull final String name,
                          @NonNull Context context,
                          @NonNull AttributeSet attrs) {
        View view = null;
        // We need to 'inject' our tint aware Views in place of the standard framework versions
        switch (name) {
            case "TextView":
                view = new SkinTextView(context, attrs);
                verifyNotNull(view, name);
                break;
            case "FrameLayout":
                view = new SkinFragmentView(context, attrs);
                verifyNotNull(view, name);
                break;
        }
        return view;
    }

    private void verifyNotNull(View view, String name) {
        if (view == null) {
            throw new IllegalStateException(this.getClass().getName() + " asked to inflate view for <" + name + ">, but returned null");
        }
    }

}