package com.syl.sugar.task;

import java.util.concurrent.Executor;

/**
 * Task -> Abstract Base Class
 *
 * Created by shenyunlong on 2/29/16.
 */
public abstract class AbsTask<T> {

    private TaskStatus mStatus;      // 状态，默认为IDLE
    private TaskPriority mPriority;  // 优先级，默认为NORMAL

    public AbsTask() {
        this(TaskPriority.NORMAL);
    }

    public AbsTask(TaskPriority priority) {
        mStatus = TaskStatus.IDLE;
        mPriority = priority;
    }

    protected abstract Executor getExecutor();

    public TaskPriority getPriority() {
        return mPriority;
    }

    /*package*/ void setStatus(TaskStatus status) {
        mStatus = status;
    }

    /*package*/ TaskStatus getStatus() {
        return mStatus;
    }

    /**
     * 以下操作会在UI线程中执行
     */
    protected abstract void onStart();
    protected abstract void onWaiting();
    protected abstract void onSuccess();
    protected abstract void onError();
    protected abstract void onCancelled();

    /**
     * 在异步线程中执行耗时操作
     */
    protected abstract void doBackground();
}
