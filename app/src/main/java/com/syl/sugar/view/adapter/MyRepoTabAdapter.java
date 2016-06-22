package com.syl.sugar.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.syl.sugar.R;
import com.syl.sugar.view.fragment.RepoListFragment;

public class MyRepoTabAdapter extends SmartFragmentStatePagerAdapter {

    public static final int[] MY_REPO_TABS = new int[]{
            R.string.my_repo_tab_1,
            R.string.my_repo_tab_2,
            R.string.my_repo_tab_3};

    private Context mContext;
    private FragmentManager mFragmentManager;

    public MyRepoTabAdapter(Context context, FragmentManager fm) {
        super(fm);

        mContext = context;
        mFragmentManager = fm;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return RepoListFragment.newInstance(0, "This is Page One !");
            case 1:
                return RepoListFragment.newInstance(1, "This is Page Two !");
            case 2:
                return RepoListFragment.newInstance(2, "This is Page Three !");
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return MY_REPO_TABS.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position >= 0 && position < MY_REPO_TABS.length) {
            return mContext.getString(MY_REPO_TABS[position]);
        }

        return null;
    }
}
