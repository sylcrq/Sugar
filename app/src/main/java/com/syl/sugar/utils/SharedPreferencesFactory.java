package com.syl.sugar.utils;

import android.content.Context;

/**
 * Saving Key-Value Sets
 *
 * Created by syl on 16/2/23.
 */
public class SharedPreferencesFactory {

    public static final String PREFERENCE_FILE_KEY = "com.syl.sugar.PREFERENCE_FILE_KEY";

    private Context mContext;

    private static SharedPreferencesFactory mInstance;  // 单例

    private SharedPreferencesFactory(Context context) {
        this.mContext = context;
    }

    public static SharedPreferencesFactory getInstance(Context context) {
        if(mInstance == null) {
            mInstance = new SharedPreferencesFactory(context);
        }

        return mInstance;
    }

    public SharedPreferencesWrapper build(String key) {
        return new SharedPreferencesWrapper(mContext, key);
    }
}
