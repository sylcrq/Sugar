package com.syl.aop.utils;

import java.util.concurrent.TimeUnit;

/**
 * Created by shenyunlong on 2/22/16.
 */
public class StopWatch {

    private long mStart;
    private long mEnd;
    private long mElapsed;

    public StopWatch() {
    }

    public void reset() {
        mStart = 0;
        mEnd = 0;
        mElapsed = 0;
    }

    public void start() {
        reset();
//        mStart = System.currentTimeMillis();
        mStart = System.nanoTime();
    }

    public void stop() {
        if(mStart != 0) {
//            mEnd = System.currentTimeMillis();
            mEnd = System.nanoTime();
            mElapsed = (mEnd - mStart);
        }
    }

    public long getElapsedTime() {
        return (mElapsed != 0 ? TimeUnit.NANOSECONDS.toMillis(mElapsed) : 0);
    }
}
