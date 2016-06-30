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
import com.syl.sugar.view.adapter.MainNotificationTabAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 首页Notifications页面
 */
public class MainNotificationFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    @Bind(R.id.common_pager_sliding_tab)
    PagerSlidingTabStrip mPagerSlidingTab;
    @Bind(R.id.common_view_pager)
    ViewPager mViewPager;

    private Context mContext;
    private MainNotificationTabAdapter mAdapter;

    public MainNotificationFragment() {
    }

    public static MainNotificationFragment newInstance(String param1) {
        MainNotificationFragment fragment = new MainNotificationFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_notification, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new MainNotificationTabAdapter(mContext, getFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mPagerSlidingTab.setViewPager(mViewPager);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
