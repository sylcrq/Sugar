package com.syl.sugar.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.syl.sugar.R;
import com.syl.sugar.view.fragment.IssueListFragment;

/**
 * 首页Issue Tab页面Adapter
 * <p/>
 * Created by Shen YunLong on 2016/06/30.
 */
public class MainIssueTabAdapter extends SmartFragmentStatePagerAdapter {

    private Context mContext;
    private FragmentManager mFragmentManager;
    private String[] mTabs;

    public MainIssueTabAdapter(Context context, FragmentManager fm) {
        super(fm);

        this.mContext = context;
        this.mFragmentManager = fm;
        this.mTabs = context.getResources().getStringArray(R.array.issue_tab_array);
    }

    @Override
    public Fragment getItem(int position) {
        if (position >= 0 && position < getCount()) {
            return IssueListFragment.newInstance("");
        }

        return null;
    }

    @Override
    public int getCount() {
        return (mTabs != null) ? mTabs.length : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position >= 0 && position < getCount()) {
            return mTabs[position];
        }

        return null;
    }
}
