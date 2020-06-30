package com.tang.skin;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.core.content.ContextCompat;

/**
 * 作者:  tang
 * 时间： 2020/4/30 0030 下午 5:40
 * 邮箱： 3349913147@qq.com
 * 描述：
 */
public class SkinFragmentView extends FrameLayout implements ViewsMatch {

    private int resourceId;

    public SkinFragmentView(Context context) {
        this(context, null);
    }

    public SkinFragmentView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinFragmentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        // 根据自定义属性，匹配控件属性的类型集合，如：background
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.SkinFragmentView,
                defStyleAttr, 0);
        resourceId = typedArray.getResourceId(0, -1);
        // 这一句回收非常重要！obtainStyledAttributes()有语法提示！！
        typedArray.recycle();
    }

    @Override
    public void skinView() {
        int backgroundResourceId = resourceId;
        if (backgroundResourceId > 0) {
            // 兼容包转换
            Drawable drawable = ContextCompat.getDrawable(getContext(), backgroundResourceId);
            // 控件自带api，这里不用setBackgroundColor()因为在9.0测试不通过
            // setBackgroundDrawable在这里是过时了
            setBackground(drawable);
        }
    }
}