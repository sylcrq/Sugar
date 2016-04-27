package com.syl.domain.interactor;

import com.syl.domain.executor.PostExecutionThread;
import com.syl.domain.executor.ThreadExecutor;
import com.syl.domain.repository.GitHubRepository;

import java.util.List;

/**
 * Created by shenyunlong on 16/4/27.
 */
public class GetEventsUseCaseImpl implements GetEventsUseCase {

    private String userName;
    private Callback callback;

    private GitHubRepository repository;
    private ThreadExecutor executor;
    private PostExecutionThread postExecutionThread;

    public GetEventsUseCaseImpl(GitHubRepository repository, ThreadExecutor executor, PostExecutionThread postExecutionThread) {
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
        repository.getUserEvents(userName, new GitHubRepository.Callback() {
            @Override
            public void onSuccess(final List list) {
                postExecutionThread.post(new Runnable() {
                    @Override
                    public void run() {
                        if (callback != null) {
                            callback.onSuccess(list);
                        }
                    }
                });
            }

            @Override
            public void onError(final Exception e) {
                postExecutionThread.post(new Runnable() {
                    @Override
                    public void run() {
                        if(callback != null) {
                            callback.onError(e);
                        }
                    }
                });
            }
        });
    }
}
