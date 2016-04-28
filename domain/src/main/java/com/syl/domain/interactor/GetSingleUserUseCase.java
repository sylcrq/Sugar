package com.syl.domain.interactor;

import com.syl.domain.model.User;

/**
 * Created by shenyunlong on 16/4/28.
 */
public interface GetSingleUserUseCase extends Interactor {

    interface Callback {
        void onSuccess(User user);

        void onError(Exception e);
    }

    void execute(String userName, Callback callback);
}
