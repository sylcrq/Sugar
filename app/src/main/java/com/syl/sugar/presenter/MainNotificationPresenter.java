package com.syl.sugar.presenter;

import com.syl.data.JobExecutor;
import com.syl.data.repository.GitHubDataRepository;
import com.syl.domain.interactor.GetMyNotificationUseCase;
import com.syl.domain.interactor.GetMyNotificationUseCaseImpl;
import com.syl.domain.model.Notification;
import com.syl.sugar.UIThread;
import com.syl.sugar.view.MainNotificationView;
import com.syl.sugar.view.fragment.NotificationListFragment;

import java.util.List;

/**
 * Created by Shen YunLong on 2016/07/26.
 */
public class MainNotificationPresenter extends BaseListPresenter {

    public MainNotificationPresenter(MainNotificationView view) {
        super(view);
    }

    @Override
    public void loadData(int page) {
        if (mView != null && mView instanceof NotificationListFragment) {
            boolean isAll = ((NotificationListFragment) mView).isAll();
            boolean isParticipating = ((NotificationListFragment) mView).isParticipating();

            final boolean hasData = ((NotificationListFragment) mView).hasData();
            final boolean isLoadMore = page > 1;

            startLoadData(!hasData);

            GetMyNotificationUseCase useCase =
                    new GetMyNotificationUseCaseImpl(GitHubDataRepository.getInstance(),
                            JobExecutor.getInstance(), UIThread.getInstance());

            useCase.execute(isAll, isParticipating, new GetMyNotificationUseCase.Callback() {
                @Override
                public void onSuccess(List<Notification> notifications) {
                    ((NotificationListFragment) mView).refreshComplete();
                    onLoadOk(!hasData && notifications.isEmpty());
                    ((NotificationListFragment) mView).render(notifications, isLoadMore);
                }

                @Override
                public void onError(Exception e) {
                    ((NotificationListFragment) mView).refreshComplete();
                    onLoadError(!hasData);
                    ((NotificationListFragment) mView).showToast("" + e);
                }
            });
        }
    }
}
