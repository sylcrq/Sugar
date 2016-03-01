package com.syl.sugar.task;

/**
 * Task Manager
 *
 * Created by shenyunlong on 2/29/16.
 */
public class TaskManager {

    private static TaskManager mInstance;  // 单例

    private TaskManager() {
    }

    public static TaskManager getInstance() {
        if(mInstance == null) {
            mInstance = new TaskManager();
        }

        return mInstance;
    }

    /**
     * 执行异步任务
     *
     * @param task
     */
    public <T> void start(AbsTask<T> task) {
        if(task instanceof TaskProxy) {
            task.doBackground();
        } else {
            TaskProxy<T> taskProxy = new TaskProxy<>(task);
            taskProxy.doBackground();
        }
    }
}
