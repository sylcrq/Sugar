package com.syl.sugar.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.syl.sugar.EndlessRecyclerViewScrollListener;
import com.syl.sugar.R;
import com.syl.sugar.activity.adapter.GankAdapter;
import com.syl.sugar.activity.presenter.GankPresenter;
import com.syl.sugar.event.MessageEvent;
import com.syl.sugar.model.WelfareResponse;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class GankActivity extends SwipeBackActivity implements GankView {

    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.loading_bar)
    ProgressBar mProgressBar;
    @Bind(R.id.empty_page_hint)
    TextView mEmptyHint;

    private GankPresenter mGankPresenter;
    private GankAdapter mGankAdapter;
    private StaggeredGridLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gank);

        ButterKnife.bind(this);

        // 下拉刷新
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mGankPresenter.loadData(1, true);
            }
        });
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        mGankPresenter = new GankPresenter(this);
        mGankAdapter = new GankAdapter(this);
        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        // RecyclerView
        mRecyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(5, 1, mLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                mGankPresenter.loadData(page, false);
            }
        });
        mRecyclerView.setAdapter(mGankAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);

        mGankPresenter.loadData(1, false);
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void showContentPage() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideContentPage() {
        mRecyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showEmptyPage() {
        mEmptyHint.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmptyPage() {
        mEmptyHint.setVisibility(View.GONE);
    }

    @Override
    public void stopRefresh() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showToast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void appendData(List<WelfareResponse.Welfare> data) {
        mGankAdapter.append(data);
    }

    @Override
    public void resetData(List<WelfareResponse.Welfare> data) {
        mGankAdapter.clear();
        mGankAdapter.addAll(data);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        showToast(event.message);
    }
}
