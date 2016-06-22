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
import com.syl.sugar.view.adapter.MyRepoTabAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 首页Repositories页面
 */
public class MyRepoFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    @Bind(R.id.repo_pager_sliding_tab)
    PagerSlidingTabStrip mPagerSlidingTab;
    @Bind(R.id.repo_view_pager)
    ViewPager mViewPager;

    private Context mContext;
    private MyRepoTabAdapter mAdapter;

    public MyRepoFragment() {
    }

    public static MyRepoFragment newInstance(String param1) {
        MyRepoFragment fragment = new MyRepoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_repo, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new MyRepoTabAdapter(mContext, getFragmentManager());
        mViewPager.setAdapter(mAdapter);

        mPagerSlidingTab.setViewPager(mViewPager);
//        mPagerAdapter = new MyPagerAdapter(getFragmentManager());
//        mViewPager.setAdapter(mPagerAdapter);
//        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                Toast.makeText(getActivity(), "Select Page " + position, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//            }
//        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
