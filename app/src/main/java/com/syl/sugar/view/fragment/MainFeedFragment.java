package com.syl.sugar.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.syl.domain.model.Event;
import com.syl.sugar.NavigationTool;
import com.syl.sugar.R;
import com.syl.sugar.view.MainFeedView;
import com.syl.sugar.view.adapter.FeedListAdapter;
import com.syl.sugar.presenter.MainFeedPresenter;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * 首页Feed页面
 *
 * @see MainFeedView
 * @see MainFeedPresenter
 */
public class MainFeedFragment extends Fragment implements MainFeedView, AdapterView.OnItemClickListener {

    private static final String ARG_USER_NAME = "ARG_USER_NAME";

    @Bind(R.id.common_ptr_layout)
    PtrClassicFrameLayout mPtrFrame;
    @Bind(R.id.common_list_view)
    ListView mListView;
    @Bind(R.id.common_loading_view)
    AVLoadingIndicatorView mLoadingView;
    @Bind(R.id.common_empty_view)
    View mEmptyView;
    @Bind(R.id.common_error_view)
    View mErrorView;

    private String mUserName;
    private Context mContext;
    private FeedListAdapter mAdapter;
    private MainFeedPresenter mMainFeedPresenter;

    public MainFeedFragment() {
    }

    public static MainFeedFragment newInstance(String userName) {
        MainFeedFragment fragment = new MainFeedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USER_NAME, userName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUserName = getArguments().getString(ARG_USER_NAME);
        }

        mAdapter = new FeedListAdapter(mContext);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_feed, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPtrFrame.setLastUpdateTimeRelateObject(this);
        mPtrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mMainFeedPresenter.loadData(mUserName, 1, hasData());
            }
        });

        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);

        mMainFeedPresenter = new MainFeedPresenter(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }

    @Override
    public void onResume() {
        super.onResume();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                mPtrFrame.autoRefresh();
            }
        }, 100);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private boolean hasData() {
        if (mAdapter != null && mAdapter.getCount() > 0) {
            return true;
        }

        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Event event = (Event) mAdapter.getItem(position);
        NavigationTool.gotoSingleUserActivity(mContext, event.getActor().getLogin());
    }

    @Override
    public void showLoadingView(boolean show) {
        mLoadingView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showErrorView(boolean show) {
        mErrorView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showEmptyView(boolean show) {
        mEmptyView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showContent(boolean show) {
        mPtrFrame.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void refreshComplete() {
        mPtrFrame.refreshComplete();
    }

    @Override
    public void render(List<Event> events, boolean isLoadMore) {
        if (isLoadMore) {
            mAdapter.addData(events);
        } else {
            mAdapter.setData(events);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

}
