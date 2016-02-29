package com.syl.sugar.task;

/**
 * 支持优先级的Runnable (限制包内访问)
 *
 * Created by shenyunlong on 2/29/16.
 */
/*package*/ abstract class PriorityRunnable implements Runnable {

    private int mPriority = 0;  // 默认优先级为0

    public PriorityRunnable(int priority) {
        mPriority = priority;
    }

    public int getPriority() {
        return mPriority;
    }
}
