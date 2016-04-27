package com.syl.domain.interactor;

import com.syl.domain.model.Events;

import java.util.List;

/**
 * Created by shenyunlong on 16/4/27.
 */
public interface GetEventsUseCase extends Interactor {

    interface Callback {
        void onSuccess(List<Events> list);

        void onError(Exception e);
    }

    void execute(String userName, Callback callback);
}
