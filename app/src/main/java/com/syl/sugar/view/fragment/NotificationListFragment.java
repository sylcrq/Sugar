package com.syl.sugar.view.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Toast;

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
    public static final String ARG_SHOW_ALL = "ARG_SHOW_ALL";
    public static final String ARG_SHOW_PARTICIPATING = "ARG_SHOW_PARTICIPATING";

    private boolean mAll;
    private boolean mParticipating;

    public NotificationListFragment() {
    }

    public static NotificationListFragment newInstance(boolean all, boolean participating) {
        NotificationListFragment fragment = new NotificationListFragment();
        Bundle args = new Bundle();
        args.putBoolean(ARG_SHOW_ALL, all);
        args.putBoolean(ARG_SHOW_PARTICIPATING, participating);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mAll = getArguments().getBoolean(ARG_SHOW_ALL);
            mParticipating = getArguments().getBoolean(ARG_SHOW_PARTICIPATING);
        }
    }

    @Override
    public ListAdapter initAdapter() {
        return new NotificationListAdapter(mContext);
    }

    @Override
    public BaseListPresenter initPresenter() {
        return new MainNotificationPresenter(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        showToast("notification");
    }

    @Override
    public void refreshComplete() {
        mPtrFrame.refreshComplete();
    }

    @Override
    public void render(List<Notification> notifications, boolean isLoadMore) {
        if (mListAdapter != null && mListAdapter instanceof NotificationListAdapter) {
            if (isLoadMore) {
                ((NotificationListAdapter) mListAdapter).addData(notifications);
            } else {
                ((NotificationListAdapter) mListAdapter).setData(notifications);
            }

            ((NotificationListAdapter) mListAdapter).notifyDataSetInvalidated();
        }
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    public boolean isAll() {
        return mAll;
    }

    public boolean isParticipating() {
        return mParticipating;
    }
}
