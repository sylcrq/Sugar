package com.syl.executor;

/**
 * 执行异步任务
 *
 * Created by shenyunlong on 4/8/16.
 */
public interface ThreadExecutor {

    void execute(Runnable runnable);
}
