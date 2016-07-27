package com.syl.sugar.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import com.syl.domain.model.Issue;
import com.syl.sugar.presenter.BaseListPresenter;
import com.syl.sugar.presenter.MainIssuePresenter;
import com.syl.sugar.view.MainIssueView;
import com.syl.sugar.view.adapter.IssueListAdapter;

import java.util.List;

/**
 * Issue列表的Fragment
 * <p/>
 * Created by Shen YunLong on 2016/07/26
 */
public class IssueListFragment extends BaseListFragment implements MainIssueView {
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public IssueListFragment() {
    }

    public static IssueListFragment newInstance(String param1) {
        IssueListFragment fragment = new IssueListFragment();
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
        return new IssueListAdapter();
    }

    @Override
    public BaseListPresenter initPresenter() {
        return new MainIssuePresenter(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void refreshComplete() {

    }

    @Override
    public void render(List<Issue> issues, boolean isLoadMore) {

    }

    @Override
    public void showToast(String message) {

    }
}
