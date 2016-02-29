package com.syl.sugar.task;

import java.util.concurrent.Executor;

/**
 * Task Manager
 *
 * Created by shenyunlong on 2/29/16.
 */
public class TaskManager {

    private Executor mDefaultExecutor = new PriorityExecutor();  // 默认线程池

    private static TaskManager mInstance;  // 单例

    private TaskManager() {
    }

    public static TaskManager getInstance() {
        if(mInstance == null) {
            mInstance = new TaskManager();
        }

        return mInstance;
    }

    public Executor getDefaultExecutor() {
        return mDefaultExecutor;
    }

    /**
     * 执行异步任务
     *
     * @param task
     */
    public void start(AbsTask task) {
        if(task instanceof TaskProxy) {
            task.doBackground();
        } else {
            TaskProxy taskProxy = new TaskProxy(task);
            taskProxy.doBackground();
        }
    }
}
