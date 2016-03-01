package com.syl.sugar;

import com.syl.aop.annotation.DebugTrace;
import com.syl.sugar.task.AbsTask;
import com.syl.sugar.task.PriorityExecutor;
import com.syl.sugar.task.TaskPriority;
import java.util.concurrent.Executor;

/**
 * 模拟数据库任务
 *
 * Created by shenyunlong on 2/29/16.
 */
public class DbTask<T> extends AbsTask<T> {

    private static final Executor sExecutor = new PriorityExecutor();

    public DbTask() {
        super(TaskPriority.HIGH);
    }

    @DebugTrace
    @Override
    protected void doBackground() {
        // 进行耗时的异步操作
        try {
            Thread.sleep(1024);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Executor getExecutor() {
        return sExecutor;
    }

    @DebugTrace
    @Override
    protected void onStart() {
    }

    @DebugTrace
    @Override
    protected void onWaiting() {
    }

    @DebugTrace
    @Override
    protected void onSuccess() {
    }

    @DebugTrace
    @Override
    protected void onError() {
    }

    @DebugTrace
    @Override
    protected void onCancelled() {
    }
}
