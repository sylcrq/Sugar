package com.syl.domain.interactor;

import com.syl.domain.model.Event;

import java.util.List;

/**
 * Created by shenyunlong on 16/4/27.
 */
public interface GetEventsUseCase extends Interactor {

    interface Callback {
        void onSuccess(List<Event> list);

        void onError(Exception e);
    }

    void execute(String userName, int page, Callback callback);
}
