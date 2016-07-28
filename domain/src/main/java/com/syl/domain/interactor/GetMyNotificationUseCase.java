package com.syl.domain.interactor;

import com.syl.domain.model.Notification;

import java.util.List;

/**
 * Created by Shen YunLong on 2016/07/28.
 */
public interface GetMyNotificationUseCase extends Interactor {

    interface Callback {
        void onSuccess(List<Notification> notifications);

        void onError(Exception e);
    }

    void execute(boolean all, boolean participating, Callback callback);
}
