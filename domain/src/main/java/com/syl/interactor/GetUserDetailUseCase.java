package com.syl.interactor;

import com.syl.model.User;
import com.syl.repository.UserRepository;

/**
 * Created by shenyunlong on 4/7/16.
 */
public class GetUserDetailUseCase {

    UserRepository mRepository;

    public GetUserDetailUseCase(UserRepository repository) {
        mRepository = repository;
    }

    public void getUserById(int userId, final GetUserDetailCallback callback) {
        mRepository.getUserDetail(userId, new UserRepository.GetUserDetailCallback() {
            @Override
            public void onSuccess(User user) {
                callback.onSuccess(user);
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }

    public interface GetUserDetailCallback {
        void onSuccess(User user);
        void onError();
    }

}
