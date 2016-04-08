package com.syl.sugar;

import android.os.Handler;
import android.os.Looper;

import com.syl.executor.PostExecutionThread;

/**
 * Created by shenyunlong on 4/8/16.
 */
public class UIThread implements PostExecutionThread {

    private Handler mHandler;

    /* 单例 */
    private static UIThread mInstance;

    private UIThread() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    public static UIThread getInstance() {
        if(mInstance == null) {
            mInstance = new UIThread();
        }

        return mInstance;
    }

    @Override
    public void post(Runnable runnable) {
        mHandler.post(runnable);
    }
}
