package com.syl.sugar.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.syl.sugar.R;
import com.syl.sugar.activity.adapter.GankAdapter;
import com.syl.sugar.activity.presenter.GankPresenter;
import com.syl.sugar.model.WelfareResponse;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;

public class GankActivity extends AppCompatActivity implements GankView {

    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.loading_bar)
    ProgressBar mProgressBar;
    @Bind(R.id.empty_page_hint)
    TextView mEmptyHint;

    private GankPresenter mGankPresenter;
    private GankAdapter mGankAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gank);

        ButterKnife.bind(this);
        mGankPresenter = new GankPresenter(this);

        mGankAdapter = new GankAdapter(this);
        mRecyclerView.setAdapter(mGankAdapter);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected void onResume() {
        super.onResume();

        mGankPresenter.loadData();
    }

    @Override
    protected void onPause() {
        super.onPause();
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
    public void bindData(List<WelfareResponse.Welfare> welfares) {
        mGankAdapter.setData(welfares);
        mGankAdapter.notifyDataSetChanged();
    }
}
