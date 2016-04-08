package com.syl.domain.interactor;

import com.syl.domain.executor.PostExecutionThread;
import com.syl.domain.executor.ThreadExecutor;
import com.syl.domain.model.User;
import com.syl.domain.repository.UserRepository;

/**
 * Created by shenyunlong on 4/7/16.
 */
public class GetUserDetailUseCaseImpl implements GetUserDetailUseCase {

    private UserRepository mUserRepository;
    private ThreadExecutor mThreadExecutor;
    private PostExecutionThread mPostExecutionThread;

    private int mUserId;
    private Callback mCallback;

    public GetUserDetailUseCaseImpl(UserRepository userRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.mUserRepository = userRepository;
        this.mThreadExecutor = threadExecutor;
        this.mPostExecutionThread = postExecutionThread;
    }

    @Override
    public void execute(int userId, Callback callback) {
        this.mUserId = userId;
        this.mCallback = callback;
        mThreadExecutor.execute(this);
    }

    @Override
    public void run() {
        mUserRepository.getUserDetail(mUserId, mGetUserDetailCallback);
    }

    private final UserRepository.GetUserDetailCallback mGetUserDetailCallback = new UserRepository.GetUserDetailCallback() {
        @Override
        public void onSuccess(final User user) {
            mPostExecutionThread.post(new Runnable() {
                @Override
                public void run() {
                    mCallback.onSuccess(user);
                }
            });
        }

        @Override
        public void onError() {
            mPostExecutionThread.post(new Runnable() {
                @Override
                public void run() {
                    mCallback.onError();
                }
            });
        }
    };
}
