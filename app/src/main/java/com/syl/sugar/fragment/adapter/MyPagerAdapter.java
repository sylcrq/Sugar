package com.syl.sugar.fragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.syl.sugar.fragment.FirstFragment;

/**
 * Created by shenyunlong on 4/1/16.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

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
