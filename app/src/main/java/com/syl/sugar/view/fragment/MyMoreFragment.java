package com.syl.sugar.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.syl.sugar.R;

/**
 * 首页More页面
 */
public class MyMoreFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public MyMoreFragment() {
    }

    public static MyMoreFragment newInstance(String param1) {
        MyMoreFragment fragment = new MyMoreFragment();
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
        return inflater.inflate(R.layout.fragment_my_more, container, false);
    }

}
