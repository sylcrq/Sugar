package com.syl.aop;

/**
 * Created by shenyunlong on 2/22/16.
 */
public class DebugTimer {

    private long mStart;
    private long mEnd;
    private long mDuration;

    public DebugTimer() {
    }

    public void reset() {
        mStart = 0;
        mEnd = 0;
        mDuration = 0;
    }

    public void start() {
        reset();
        mStart = System.currentTimeMillis();
    }

    public void stop() {
        if(mStart != 0) {
            mEnd = System.currentTimeMillis();
            mDuration = (mEnd - mStart);
        }
    }

    public long getDuration() {
        return mDuration;
    }
}
