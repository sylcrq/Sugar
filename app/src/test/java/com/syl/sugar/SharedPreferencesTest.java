package com.syl.sugar;

import android.content.Context;
import android.content.SharedPreferences;
import com.syl.sugar.utils.SharedPreferencesFactory;
import com.syl.sugar.utils.SharedPreferencesWrapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import static org.junit.Assert.assertEquals;

/**
 * Created by syl on 16/2/24.
 */
@RunWith(RobolectricTestRunner.class)
public class SharedPreferencesTest {

    private SharedPreferencesWrapper mSharedPref;

    @Before
    public void beforeEachTest() {
        SharedPreferences sharedPref = RuntimeEnvironment.application.getSharedPreferences(SharedPreferencesFactory.PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
        mSharedPref = new SharedPreferencesWrapper(sharedPref);
    }

    @Test
    public void getStringSpAfterSetValue() {
        final String key = "key1024";

        mSharedPref.set(key, "hello");
        assertEquals("hello", mSharedPref.get(key, ""));
    }

    public void getIntSpDefaultValue() {
        final String key = "key1024";
        assertEquals(0, mSharedPref.get(key, 0));
    }
}
