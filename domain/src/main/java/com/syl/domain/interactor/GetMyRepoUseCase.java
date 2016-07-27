package com.syl.domain.interactor;

import com.syl.domain.model.Repository;

import java.util.List;

/**
 * List your repositories
 * <p/>
 * List repositories that are accessible to the authenticated user.
 * <p/>
 * This includes repositories owned by the authenticated user,
 * repositories where the authenticated user is a collaborator,
 * and repositories that the authenticated user has access to through an organization membership.
 * <p/>
 * Created by Shen YunLong on 2016/07/27.
 */
public interface GetMyRepoUseCase extends Interactor {

    interface Callback {
        void onSuccess(List<Repository> repositories);

        void onError(Exception e);
    }

    void execute(Callback callback);
}
