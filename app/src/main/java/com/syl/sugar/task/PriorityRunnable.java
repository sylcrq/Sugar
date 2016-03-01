package com.syl.sugar.task;

/**
 * 支持优先级的Runnable (限制包内访问)
 *
 * Created by shenyunlong on 2/29/16.
 */
/*package*/ class PriorityRunnable implements Runnable {

    private TaskPriority mPriority;
    private Runnable mRunnable;

    public PriorityRunnable(Runnable runnable, TaskPriority priority) {
        mRunnable = runnable;
        mPriority = priority;
    }

    public TaskPriority getPriority() {
        return mPriority;
    }

    @Override
    public void run() {
        mRunnable.run();
    }
}
