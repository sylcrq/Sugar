package com.syl.sugar;

import com.syl.aop.annotation.DebugTrace;
import com.syl.sugar.task.AbsTask;

/**
 * 模拟数据库任务
 *
 * Created by shenyunlong on 2/29/16.
 */
public class DbTask extends AbsTask {

    public DbTask() {
        super(1);
    }

    @DebugTrace
    @Override
    public void doBackground() {
        // 进行耗时的异步操作
        try {
            Thread.sleep(1024);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @DebugTrace
    @Override
    public void onStart() {
    }

    @DebugTrace
    @Override
    public void onWaiting() {
    }

    @DebugTrace
    @Override
    public void onSuccess() {
    }

    @DebugTrace
    @Override
    public void onError() {
    }

    @DebugTrace
    @Override
    public void onCancelled() {
    }
}
