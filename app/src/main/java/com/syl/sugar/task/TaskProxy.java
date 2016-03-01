package com.syl.sugar.task;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Executor;

/**
 * Task Proxy (限制包内访问)
 *
 * Created by shenyunlong on 2/29/16.
 */
/*package*/ class TaskProxy<T> extends AbsTask<T> {

    private static final int MESSAGE_START = 1024;
    private static final int MESSAGE_WAITING = MESSAGE_START + 1;
    private static final int MESSAGE_SUCCESS = MESSAGE_WAITING + 1;
    private static final int MESSAGE_ERROR = MESSAGE_SUCCESS + 1;
    private static final int MESSAGE_CANCELLED = MESSAGE_ERROR + 1;

    private AbsTask<T> mTask;
    private Executor mExecutor;

    private static InternalHandler sHandler = new InternalHandler();

    public TaskProxy(AbsTask<T> task) {
        mTask = task;
        mExecutor = task.getExecutor();
    }

    @Override
    protected void doBackground() {
        TaskPriority priority = mTask.getPriority();

        Runnable runnable = new PriorityRunnable(new Runnable() {
            @Override
            public void run() {
                try {
                    // TODO: 3/1/16
                    // Cancel ?
                    TaskProxy.this.onStart();

                    // Cancel ?
                    mTask.doBackground();

                    // Cancel ?
                    TaskProxy.this.onSuccess();
                } catch (Exception e) {
                    e.printStackTrace();
                    TaskProxy.this.onError();
                }
            }
        }, priority);

        mExecutor.execute(runnable);
    }

    @Override
    protected Executor getExecutor() {
        return mExecutor;
    }

    @Override
    protected void onStart() {
        setStatus(TaskStatus.STARTED);
        sHandler.obtainMessage(MESSAGE_START, this).sendToTarget();
    }

    @Override
    protected void onWaiting() {
        setStatus(TaskStatus.WAITING);
        sHandler.obtainMessage(MESSAGE_WAITING, this).sendToTarget();
    }

    @Override
    protected void onSuccess() {
        setStatus(TaskStatus.SUCCESS);
        sHandler.obtainMessage(MESSAGE_SUCCESS, this).sendToTarget();
    }

    @Override
    protected void onError() {
        setStatus(TaskStatus.ERROR);
        sHandler.obtainMessage(MESSAGE_ERROR, this).sendToTarget();
    }

    @Override
    protected void onCancelled() {
        setStatus(TaskStatus.CANCELLED);
        sHandler.obtainMessage(MESSAGE_CANCELLED, this).sendToTarget();
    }

    /**
     * Handler
     */
    /*package*/ static class InternalHandler extends Handler {

        public InternalHandler() {
            super(Looper.getMainLooper());
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            TaskProxy taskProxy = (TaskProxy) msg.obj;
            if(taskProxy == null) {
                return;
            }

            switch (msg.what) {
                case MESSAGE_START:
                    taskProxy.mTask.onStart();
                    break;
                case MESSAGE_WAITING:
                    taskProxy.mTask.onWaiting();
                    break;
                case MESSAGE_SUCCESS:
                    taskProxy.mTask.onSuccess();
                    break;
                case MESSAGE_ERROR:
                    taskProxy.mTask.onError();
                    break;
                case MESSAGE_CANCELLED:
                    taskProxy.mTask.onCancelled();
                    break;
            }
        }
    }
}
