package com.syl.sugar.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.syl.sugar.R;
import com.syl.sugar.view.adapter.SmartFragmentStatePagerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public abstract class BaseTabFragment extends Fragment {

    protected Context mContext;
    protected SmartFragmentStatePagerAdapter mPagerAdapter;

    @Bind(R.id.common_pager_sliding_tab)
    PagerSlidingTabStrip mPagerSlidingTab;
    @Bind(R.id.common_view_pager)
    ViewPager mViewPager;

    public BaseTabFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPagerAdapter = initAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base_tab, container, false);
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
    }

    @Override
    public void onPause() {
        super.onPause();
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

    private void initView() {
        mViewPager.setAdapter(mPagerAdapter);
        mPagerSlidingTab.setViewPager(mViewPager);
    }

    public abstract SmartFragmentStatePagerAdapter initAdapter();
}
