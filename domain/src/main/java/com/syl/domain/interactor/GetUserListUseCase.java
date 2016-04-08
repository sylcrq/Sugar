package com.syl.domain.interactor;

import com.syl.domain.model.User;
import java.util.List;

/**
 * 获取用户列表逻辑的接口
 *
 * Created by shenyunlong on 4/8/16.
 */
public interface GetUserListUseCase extends Interactor {

    interface Callback {
        void onSuccess(List<User> users);
        void onError();
    }

    void execute(Callback callback);
}
