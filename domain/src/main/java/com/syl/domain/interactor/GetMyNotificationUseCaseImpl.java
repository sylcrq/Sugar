package com.syl.domain.interactor;

import com.syl.domain.executor.PostExecutionThread;
import com.syl.domain.executor.ThreadExecutor;
import com.syl.domain.model.Notification;
import com.syl.domain.repository.GitHubRepository;

import java.util.List;

/**
 * Created by Shen YunLong on 2016/07/28.
 */
public class GetMyNotificationUseCaseImpl implements GetMyNotificationUseCase {

    private GitHubRepository mRepository;
    private ThreadExecutor mThreadExecutor;
    private PostExecutionThread mPostExecutionThread;
    private Callback mCallback;
    private boolean mAll;
    private boolean mParticipating;

    public GetMyNotificationUseCaseImpl(GitHubRepository repository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        mRepository = repository;
        mThreadExecutor = threadExecutor;
        mPostExecutionThread = postExecutionThread;
    }

    @Override
    public void execute(boolean all, boolean participating, Callback callback) {
        mAll = all;
        mParticipating = participating;
        mCallback = callback;

        mThreadExecutor.execute(this);
    }

    @Override
    public void run() {
        mRepository.getNotifications(mAll, mParticipating, new GitHubRepository.GetDataListCallback<Notification>() {
            @Override
            public void onSuccess(final List<Notification> list) {
                mPostExecutionThread.post(new Runnable() {
                    @Override
                    public void run() {
                        if (mCallback != null) {
                            mCallback.onSuccess(list);
                        }
                    }
                });
            }

            @Override
            public void onError(final Exception e) {
                mPostExecutionThread.post(new Runnable() {
                    @Override
                    public void run() {
                        if (mCallback != null) {
                            mCallback.onError(e);
                        }
                    }
                });
            }
        });
    }
}
