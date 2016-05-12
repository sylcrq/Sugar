package com.syl.data;

import com.syl.domain.executor.ThreadExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by shenyunlong on 4/8/16.
 */
public class JobExecutor implements ThreadExecutor {

    public static final int CORE_POOL_SIZE = 5;
    public static final int MAX_POOL_SIZE = 10;
    public static final int KEEP_ALIVE_TIME = 10;
    public static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    private BlockingQueue<Runnable> mBlockingQueue;
    private ThreadPoolExecutor mExecutor;

    /* 单例 */
    private static JobExecutor mInstance;

    private JobExecutor() {
        this.mBlockingQueue = new LinkedBlockingQueue<>();
        this.mExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE,
                KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT,
                mBlockingQueue);
    }

    public synchronized static JobExecutor getInstance() {
        if (mInstance == null) {
            mInstance = new JobExecutor();
        }

        return mInstance;
    }

    @Override
    public void execute(Runnable runnable) {
        mExecutor.execute(runnable);
    }
}
