package com.syl.sugar.view.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import com.syl.domain.model.Notification;
import com.syl.sugar.presenter.BaseListPresenter;
import com.syl.sugar.presenter.MainNotificationPresenter;
import com.syl.sugar.view.MainNotificationView;
import com.syl.sugar.view.adapter.NotificationListAdapter;

import java.util.List;

/**
 * 通知列表Fragment
 * <p/>
 * Created by Shen YunLong on 2016/05/05
 */
public class NotificationListFragment extends BaseListFragment implements MainNotificationView {
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public NotificationListFragment() {
    }

    public static NotificationListFragment newInstance(String param1) {
        NotificationListFragment fragment = new NotificationListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public ListAdapter initAdapter() {
        return new NotificationListAdapter();
    }

    @Override
    public BaseListPresenter initPresenter() {
        return new MainNotificationPresenter();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void refreshComplete() {

    }

    @Override
    public void render(List<Notification> notifications, boolean isLoadMore) {

    }

    @Override
    public void showToast(String message) {

    }
}
