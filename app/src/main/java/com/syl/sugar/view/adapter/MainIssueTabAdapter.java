package com.syl.sugar.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.syl.sugar.R;
import com.syl.sugar.view.fragment.IssueListFragment;

/**
 * Created by Shen YunLong on 2016/06/30.
 */
public class MainIssueTabAdapter extends SmartFragmentStatePagerAdapter {

    public static final int[] MAIN_ISSUE_TABS = new int[]{
            R.string.main_issue_tab_open,
            R.string.main_issue_tab_closed
    };

    private Context mContext;
    private FragmentManager mFragmentManager;

    public MainIssueTabAdapter(Context context, FragmentManager fm) {
        super(fm);

        this.mContext = context;
        this.mFragmentManager = fm;
    }

    @Override
    public Fragment getItem(int position) {
        if (position >= 0 && position < getCount()) {
            return IssueListFragment.newInstance("", "");
        }

        return null;
    }

    @Override
    public int getCount() {
        return MAIN_ISSUE_TABS.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position >= 0 && position < getCount()) {
            return mContext.getString(MAIN_ISSUE_TABS[position]);
        }

        return null;
    }
}
