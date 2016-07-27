package com.syl.domain.interactor;

import com.syl.domain.executor.PostExecutionThread;
import com.syl.domain.executor.ThreadExecutor;
import com.syl.domain.model.Repository;
import com.syl.domain.repository.GitHubRepository;

import java.util.List;

/**
 * Created by Shen YunLong on 2016/07/27.
 */
public class GetMyRepoUseCaseImpl implements GetMyRepoUseCase {

    private GitHubRepository mRepository;
    private ThreadExecutor mThreadExecutor;
    private PostExecutionThread mPostExecutionThread;
    private Callback mCallback;

    public GetMyRepoUseCaseImpl(GitHubRepository repository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        mRepository = repository;
        mThreadExecutor = threadExecutor;
        mPostExecutionThread = postExecutionThread;
    }

    @Override
    public void execute(Callback callback) {
        mCallback = callback;
        mThreadExecutor.execute(this);
    }

    @Override
    public void run() {
        mRepository.getMyRepos(new GitHubRepository.GetDataListCallback<Repository>() {
            @Override
            public void onSuccess(final List<Repository> list) {
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
