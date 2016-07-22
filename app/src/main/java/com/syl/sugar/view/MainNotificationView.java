package com.syl.sugar.view;

import com.syl.domain.model.Notification;

import java.util.List;

/**
 * Created by Shen YunLong on 2016/07/27.
 */
public interface MainNotificationView extends BaseView {

    void refreshComplete();

    void render(List<Notification> notifications, boolean isLoadMore);

    void showToast(String message);
}
