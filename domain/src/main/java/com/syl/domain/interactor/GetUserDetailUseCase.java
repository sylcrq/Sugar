package com.syl.domain.interactor;

import com.syl.domain.model.User;

/**
 * Created by shenyunlong on 4/8/16.
 */
public interface GetUserDetailUseCase extends Interactor {

    interface Callback {
        void onSuccess(User user);
        void onError();
    }

    void execute(int userId, Callback callback);
}
