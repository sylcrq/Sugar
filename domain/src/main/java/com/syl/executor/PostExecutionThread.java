package com.syl.executor;

/**
 * 从异步线程切换到主线程执行
 *
 * Created by shenyunlong on 4/8/16.
 */
public interface PostExecutionThread {

    void post(Runnable runnable);
}
