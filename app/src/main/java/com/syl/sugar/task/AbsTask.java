package com.syl.sugar.task;

import java.util.concurrent.Executor;

/**
 * Task -> Abstract Base Class
 *
 * Created by shenyunlong on 2/29/16.
 */
public abstract class AbsTask {

    private int mStatus = 0;    // 状态，默认为IDLE
    private int mPriority = 0;  // 优先级，默认为0
    private Executor mExecutor;

    public AbsTask() {
        mStatus = 0;
        mPriority = 0;
        mExecutor = TaskManager.getInstance().getDefaultExecutor();
    }

    public AbsTask(int priority) {
        mStatus = 0;
        mPriority = priority;
        mExecutor = TaskManager.getInstance().getDefaultExecutor();
    }

    public AbsTask(Executor executor, int priority) {
        mStatus = 0;
        mPriority = priority;
        mExecutor = executor;
    }

    public Executor getExecutor() {
        return mExecutor;
    }

    public int getPriority() {
        return mPriority;
    }

    public void setStatus(int status) {
        mStatus = status;
    }

    public int getStatus() {
        return mStatus;
    }

    /**
     * 以下操作会在UI线程中执行
     */
    public abstract void onStart();
    public abstract void onWaiting();
    public abstract void onSuccess();
    public abstract void onError();
    public abstract void onCancelled();

    /**
     * 在异步线程中执行耗时操作
     */
    public abstract void doBackground();
}
