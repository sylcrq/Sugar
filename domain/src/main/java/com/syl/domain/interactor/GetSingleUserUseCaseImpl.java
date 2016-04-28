package com.syl.domain.interactor;

import com.syl.domain.executor.PostExecutionThread;
import com.syl.domain.executor.ThreadExecutor;
import com.syl.domain.model.User;
import com.syl.domain.repository.GitHubRepository;

/**
 * Created by shenyunlong on 16/4/28.
 */
public class GetSingleUserUseCaseImpl implements GetSingleUserUseCase {

    private String userName;
    private Callback callback;

    private GitHubRepository repository;
    private ThreadExecutor executor;
    private PostExecutionThread postExecutionThread;

    public GetSingleUserUseCaseImpl(GitHubRepository repository, ThreadExecutor executor, PostExecutionThread postExecutionThread) {
        this.repository = repository;
        this.executor = executor;
        this.postExecutionThread = postExecutionThread;
    }

    @Override
    public void execute(String userName, Callback callback) {
        this.userName = userName;
        this.callback = callback;

        executor.execute(this);
    }

    @Override
    public void run() {
        repository.getSingleUser(userName, new GitHubRepository.GetCallback() {
            @Override
            public void onSuccess(final Object o) {
                postExecutionThread.post(new Runnable() {
                    @Override
                    public void run() {
                        if (callback != null) {
                            callback.onSuccess((User) o);
                        }
                    }
                });
            }

            @Override
            public void onError(final Exception e) {
                postExecutionThread.post(new Runnable() {
                    @Override
                    public void run() {
                        if (callback != null) {
                            callback.onError(e);
                        }
                    }
                });
            }
        });
    }
}
