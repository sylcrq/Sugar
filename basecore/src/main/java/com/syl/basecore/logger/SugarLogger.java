package com.syl.basecore.logger;


import com.orhanobut.logger.Logger;

/**
 * 封装Log接口
 * <p/>
 * Created by Shen YunLong on 2016/05/12.
 */
public class SugarLogger {

    public static void v(String tag, String msg) {
        Logger.t(tag).v(msg);
    }

    public static void d(String tag, String msg) {
        Logger.t(tag).d(msg);
    }

    public static void i(String tag, String msg) {
        Logger.t(tag).i(msg);
    }

    public static void w(String tag, String msg) {
        Logger.t(tag).w(msg);
    }

    public static void e(String tag, String msg) {
        Logger.t(tag).e(msg);
    }

}
