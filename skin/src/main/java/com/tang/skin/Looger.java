package com.tang.skin;

import android.util.Log;

/**
 * 作者:  tang
 * 时间： 2020/4/30 0030 下午 5:56
 * 邮箱： 3349913147@qq.com
 * 描述：
 */
public class Looger {

    private static final String TAG = "Looger >>> ";

    public static void e(String info) {
        Log.e(TAG, "info： " + info);
    }

}