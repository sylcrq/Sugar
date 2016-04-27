package com.syl.data.utils;

import android.util.Log;

/**
 * 打印日志接口
 * <p>
 * Created by shenyunlong on 16/4/27.
 */
public class DebugLog {

    public static int d(String tag, String msg) {
        return Log.d(tag, msg);
    }
}
