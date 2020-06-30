package com.tang.skin;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

/**
 * 作者:  tang
 * 时间： 2020/4/30 0030 下午 5:40
 * 邮箱： 3349913147@qq.com
 * 描述：
 */
public class SkinTextView extends AppCompatTextView implements ViewsMatch {

    private int resourceId;

    public SkinTextView(Context context) {
        this(context, null);
    }

    public SkinTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SkinTextView,
                defStyleAttr, 0);
        resourceId = ta.getResourceId(0, -1);
        ta.recycle();
    }

    @Override
    public void skinView() {
        // 根据自定义属性，获取styleable中的textColor属性
        int key = R.styleable.SkinTextView[R.styleable.SkinTextView_android_textColor];
        int textColorResourceId = resourceId;
        if (textColorResourceId > 0) {
            ColorStateList color = ContextCompat.getColorStateList(getContext(), textColorResourceId);
            setTextColor(color);
        }
    }

}