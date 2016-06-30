package com.syl.sugar.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.syl.sugar.R;
import com.syl.sugar.view.fragment.RepoListFragment;

public class MainRepoTabAdapter extends SmartFragmentStatePagerAdapter {

    public static final int[] MAIN_REPO_TABS = new int[]{
            R.string.main_repo_tab_owned,
            R.string.main_repo_tab_starred,
            R.string.main_repo_tab_trending
    };

    private Context mContext;
    private FragmentManager mFragmentManager;

    public MainRepoTabAdapter(Context context, FragmentManager fm) {
        super(fm);

        mContext = context;
        mFragmentManager = fm;
    }

    @Override
    public Fragment getItem(int position) {
        if (position >= 0 && position < getCount()) {
            return RepoListFragment.newInstance(position, "");
        }

        return null;
    }

    @Override
    public int getCount() {
        return MAIN_REPO_TABS.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position >= 0 && position < getCount()) {
            return mContext.getString(MAIN_REPO_TABS[position]);
        }

        return null;
    }
}
