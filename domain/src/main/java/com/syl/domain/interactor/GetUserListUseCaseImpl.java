package com.syl.domain.interactor;

import com.syl.domain.executor.PostExecutionThread;
import com.syl.domain.executor.ThreadExecutor;
import com.syl.domain.model.User;
import com.syl.domain.repository.UserRepository;
import java.util.List;

/**
 * 获取用户列表逻辑的实现
 *
 * Created by shenyunlong on 4/7/16.
 */
public class GetUserListUseCaseImpl implements GetUserListUseCase {

    private UserRepository mUserRepository;
    private ThreadExecutor mThreadExecutor;
    private PostExecutionThread mPostExecutionThread;

    private Callback mCallback;

    public GetUserListUseCaseImpl(UserRepository userRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.mUserRepository = userRepository;
        this.mThreadExecutor = threadExecutor;
        this.mPostExecutionThread = postExecutionThread;
    }

    @Override
    public void execute(Callback callback) {
        this.mCallback = callback;
        mThreadExecutor.execute(this);
    }

    @Override
    public void run() {
        mUserRepository.getUserList(mGetUserListCallback);
    }

    private final UserRepository.GetUserListCallback mGetUserListCallback = new UserRepository.GetUserListCallback() {
        @Override
        public void onSuccess(final List<User> users) {
            mPostExecutionThread.post(new Runnable() {
                @Override
                public void run() {
                    mCallback.onSuccess(users);
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
