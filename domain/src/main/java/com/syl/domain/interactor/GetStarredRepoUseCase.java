package com.syl.domain.interactor;

import com.syl.domain.model.Repository;

import java.util.List;

/**
 * List repositories being starred by a user.
 * <p/>
 * Created by Shen YunLong on 2016/07/27.
 */
public interface GetStarredRepoUseCase extends Interactor {

    interface Callback {
        void onSuccess(List<Repository> repositories);

        void onError(Exception e);
    }

    void execute(Callback callback);
}
