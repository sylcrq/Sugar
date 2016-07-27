package com.syl.sugar.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.syl.basecore.http.SugarHttpClient;
import com.syl.sugar.R;
import com.syl.sugar.presenter.BaseListPresenter;
import com.syl.sugar.view.BaseView;
import com.wang.avi.AVLoadingIndicatorView;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * 支持下拉刷新/加载更多的列表视图Fragment基类
 * <p/>
 * Created by Shen YunLong on 2016/07/22.
 */
public abstract class BaseListFragment extends Fragment implements BaseView, AdapterView.OnItemClickListener {

    protected Context mContext;
    protected ListAdapter mListAdapter;
    protected BaseListPresenter mListPresenter;

    @Bind(R.id.common_ptr_layout)
    PtrClassicFrameLayout mPtrFrame;
    @Bind(R.id.common_list_view)
    ListView mListView;
    @Bind(R.id.common_loading_view)
    AVLoadingIndicatorView mLoadingIndicator;
    @Bind(R.id.common_empty_view)
    View mEmptyView;
    @Bind(R.id.common_error_view)
    View mErrorView;

    public BaseListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mListAdapter = initAdapter();
        mListPresenter = initPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    @Override
    public void onResume() {
        super.onResume();

        mPtrFrame.autoRefresh();
    }

    @Override
    public void onPause() {
        super.onPause();

        SugarHttpClient.getInstance().cancel("");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }

    @Override
    public void showLoadingView(boolean show) {
        mLoadingIndicator.setVisibility(show ? View.VISIBLE : View.GONE);
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

    public void initView() {
        mPtrFrame.setLastUpdateTimeRelateObject(this);
        mPtrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mListPresenter.loadData(1);
            }
        });

        mListView.setAdapter(mListAdapter);
        mListView.setOnItemClickListener(this);
    }

    public ListAdapter getAdapter() {
        return mListAdapter;
    }

    public BaseListPresenter getPresenter() {
        return mListPresenter;
    }

    public abstract ListAdapter initAdapter();

    public abstract BaseListPresenter initPresenter();


    public boolean hasData() {
        if (mListAdapter != null && mListAdapter.getCount() > 0) {
            return true;
        }

        return false;
    }

}
