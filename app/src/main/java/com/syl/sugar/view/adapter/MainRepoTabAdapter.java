package com.syl.sugar.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.syl.sugar.R;
import com.syl.sugar.view.fragment.RepoListFragment;

/**
 * 首页Repo Tab页面Adapter
 * <p/>
 * Created by Shen YunLong on 2016/07/26
 */
public class MainRepoTabAdapter extends SmartFragmentStatePagerAdapter {

    private Context mContext;
    private FragmentManager mFragmentManager;
    private String[] mTabs;

    public MainRepoTabAdapter(Context context, FragmentManager fm) {
        super(fm);

        mContext = context;
        mFragmentManager = fm;
        mTabs = context.getResources().getStringArray(R.array.repo_tab_array);
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
