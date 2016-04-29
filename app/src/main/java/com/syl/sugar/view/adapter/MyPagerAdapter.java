package com.syl.sugar.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.syl.sugar.view.fragment.FirstFragment;

/**
 * Created by shenyunlong on 4/1/16.
 */
public class MyPagerAdapter extends SmartFragmentStatePagerAdapter {

    public static final int TOTAL_PAGE_NUM = 3;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FirstFragment.newInstance(0, "This is Page One !");
            case 1:
                return FirstFragment.newInstance(1, "This is Page Two !");
            case 2:
                return FirstFragment.newInstance(2, "This is Page Three !");
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return TOTAL_PAGE_NUM;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Android";
            case 1:
                return "IOS";
            case 2:
                return "Python";
            default:
                return "NULL";
        }
    }
}
