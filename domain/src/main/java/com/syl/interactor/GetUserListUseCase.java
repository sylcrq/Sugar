package com.syl.interactor;

import com.syl.model.User;
import com.syl.repository.UserRepository;

import java.util.List;

/**
 * Created by shenyunlong on 4/7/16.
 */
public class GetUserListUseCase {

    UserRepository mUserRepository;

    public GetUserListUseCase(UserRepository userRepository) {
        mUserRepository = userRepository;
    }

    public void getUserList(final GetUserListCallback callback) {
        mUserRepository.getUserList(new UserRepository.GetUserListCallback() {
            @Override
            public void onSuccess(List<User> users) {
                callback.onSuccess(users);
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }

    public interface GetUserListCallback {
        void onSuccess(List<User> users);
        void onError();
    }
}
