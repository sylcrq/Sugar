package com.syl.sugar.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by syl on 16/2/24.
 */
public class SharedPreferencesWrapper {

    private SharedPreferences mSharedPref;

    public SharedPreferencesWrapper(SharedPreferences sharedPref) {
        mSharedPref = sharedPref;
    }

    public SharedPreferencesWrapper(Context context, String key) {
        mSharedPref = context.getSharedPreferences(key, Context.MODE_PRIVATE);
    }

    /**
     * Set string value
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * Set int value
     *
     * @param key
     * @param value
     */
    public void set(String key, int value) {
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    /**
     * Get string value
     *
     * @param key
     * @param defValue
     * @return
     */
    public String get(String key, String defValue) {
        return mSharedPref.getString(key, defValue);
    }

    /**
     * Get int value
     *
     * @param key
     * @param defValue
     * @return
     */
    public int get(String key, int defValue) {
        return mSharedPref.getInt(key, defValue);
    }

    // TODO: 16/2/24
}
