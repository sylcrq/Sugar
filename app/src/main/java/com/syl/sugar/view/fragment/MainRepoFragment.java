package com.syl.sugar.view.fragment;

import android.os.Bundle;

import com.syl.sugar.view.adapter.MainRepoTabAdapter;
import com.syl.sugar.view.adapter.SmartFragmentStatePagerAdapter;


/**
 * 首页Repo Tab页面
 * <p/>
 * Created by Shen YunLong on 2016/07/26
 */
public class MainRepoFragment extends BaseTabFragment {

    public static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public MainRepoFragment() {
    }

    public static MainRepoFragment newInstance(String param1) {
        MainRepoFragment fragment = new MainRepoFragment();
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
    public SmartFragmentStatePagerAdapter initAdapter() {
        return new MainRepoTabAdapter(mContext, getFragmentManager());
    }
}
