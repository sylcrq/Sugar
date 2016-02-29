package com.syl.sugar.task;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 支持优先级的线程池
 *
 * Created by shenyunlong on 2/29/16.
 */
public class PriorityExecutor implements Executor {

    public static final int CORE_POOL_SIZE = 5;  // 线程池一般线程数
    public static final int MAX_POOL_SIZE = 20;  // 线程池最大线程数
    public static final long KEEP_ALIVE_TIME = 1;

    private BlockingQueue<Runnable> mBlockingQueue;
    private ThreadPoolExecutor mExecutor;

    /* 自定义优先级比较 */
    private Comparator<Runnable> mComparator = new Comparator<Runnable>() {
        @Override
        public int compare(Runnable lhs, Runnable rhs) {
            if(lhs instanceof PriorityRunnable && rhs instanceof PriorityRunnable) {
                // TODO: 2/29/16 优先级相同的情况下，按先后顺序
                return ((PriorityRunnable) lhs).getPriority() - ((PriorityRunnable) rhs).getPriority();
            }

            return 0;
        }
    };

//    private ThreadFactory mThreadFactory = new ThreadFactory() {
//        @Override
//        public Thread newThread(Runnable r) {
//            return null;
//        }
//    };

    public PriorityExecutor() {
        mBlockingQueue = new PriorityBlockingQueue<>(CORE_POOL_SIZE, mComparator);

        mExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE,
                KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                mBlockingQueue);
    }

    @Override
    public void execute(Runnable command) {
        mExecutor.execute(command);
    }
}
