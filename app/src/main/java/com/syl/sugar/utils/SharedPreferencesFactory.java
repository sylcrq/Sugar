package com.syl.sugar.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Saving Key-Value Sets
 *
 * Created by syl on 16/2/23.
 */
public class SharedPreferencesFactory {

    private static final String PREFERENCE_FILE_KEY = "com.syl.sugar.utils.PREFERENCE_FILE_KEY";

    private Context mContext;
    private SharedPreferences mSharedPref;

    private static SharedPreferencesFactory mInstance;  // 单例

    private SharedPreferencesFactory(Context context) {
        this.mContext = context;
        this.mSharedPref = context.getSharedPreferences(PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
    }

    public static SharedPreferencesFactory getInstance(Context context) {
        if(mInstance == null) {
            mInstance = new SharedPreferencesFactory(context);
        }

        return mInstance;
    }

    public void setString(String key, String value) {
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key, String defValue) {
        return mSharedPref.getString(key, defValue);
    }
}
