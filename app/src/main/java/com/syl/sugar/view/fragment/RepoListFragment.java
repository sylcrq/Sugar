package com.syl.sugar.view.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.syl.domain.model.Repository;
import com.syl.sugar.presenter.BaseListPresenter;
import com.syl.sugar.presenter.MainRepoPresenter;
import com.syl.sugar.view.MainRepoView;
import com.syl.sugar.view.adapter.RepoListAdapter;

import java.util.List;


/**
 * Repo列表Fragment
 * <p/>
 * Created by Shen YunLong on 2016/05/05
 */
public class RepoListFragment extends BaseListFragment implements MainRepoView {

    private static final String ARG_PAGE_TYPE = "ARG_PAGE_TYPE";

    private int mType;

    public RepoListFragment() {
    }

    public static RepoListFragment newInstance(int type) {
        RepoListFragment fragment = new RepoListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mType = getArguments().getInt(ARG_PAGE_TYPE);
        }
    }

    @Override
    public ListAdapter initAdapter() {
        return new RepoListAdapter(mContext);
    }

    @Override
    public BaseListPresenter initPresenter() {
        return new MainRepoPresenter(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        showToast("repo");
    }

    @Override
    public void refreshComplete() {
        mPtrFrame.refreshComplete();
    }

    @Override
    public void render(List<Repository> repositories, boolean isLoadMore) {
        if (mListAdapter != null && mListAdapter instanceof RepoListAdapter) {

            if (isLoadMore) {
                ((RepoListAdapter) mListAdapter).addData(repositories);
            } else {
                ((RepoListAdapter) mListAdapter).setData(repositories);
            }

            ((RepoListAdapter) mListAdapter).notifyDataSetChanged();
        }
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    public int getType() {
        return mType;
    }
}
