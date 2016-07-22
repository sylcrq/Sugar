package com.syl.sugar.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.syl.domain.model.Event;
import com.syl.sugar.NavigationTool;
import com.syl.sugar.presenter.BaseListPresenter;
import com.syl.sugar.view.MainFeedView;
import com.syl.sugar.view.adapter.FeedListAdapter;
import com.syl.sugar.presenter.MainFeedPresenter;

import java.util.List;

/**
 * 首页Feed页面
 *
 * @see MainFeedView
 * @see MainFeedPresenter
 */
public class MainFeedFragment extends BaseListFragment implements MainFeedView {
    public static final String ARG_USER_NAME = "ARG_USER_NAME";

    private String mUserName;

    public MainFeedFragment() {
    }

    public static MainFeedFragment newInstance(String username) {
        MainFeedFragment fragment = new MainFeedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USER_NAME, username);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUserName = getArguments().getString(ARG_USER_NAME);
        }
    }

    @Override
    public ListAdapter initAdapter() {
        return new FeedListAdapter(mContext);
    }

    @Override
    public BaseListPresenter initPresenter() {
        return new MainFeedPresenter(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        ListAdapter adapter = getAdapter();
//
//        Event event = (Event) adapter.getItem(position);
//        NavigationTool.gotoSingleUserActivity(mContext, event.getActor().getLogin());
        showToast("xx");
    }

    @Override
    public void refreshComplete() {
        mPtrFrame.refreshComplete();
    }

    @Override
    public void render(List<Event> events, boolean isLoadMore) {
        if (mListAdapter != null && mListAdapter instanceof FeedListAdapter) {
            if (isLoadMore) {
                ((FeedListAdapter) mListAdapter).addData(events);
            } else {
                ((FeedListAdapter) mListAdapter).setData(events);
            }

            ((FeedListAdapter) mListAdapter).notifyDataSetChanged();
        }
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    public boolean hasData() {
        if (mListAdapter != null && mListAdapter.getCount() > 0) {
            return true;
        }

        return false;
    }

    public String getUserName() {
        return mUserName;
    }
}
