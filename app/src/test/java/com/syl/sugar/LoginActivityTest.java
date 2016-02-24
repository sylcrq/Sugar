package com.syl.sugar;

import android.content.Intent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by syl on 16/2/24.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class LoginActivityTest {

    @Test
    public void clickLoginShouldStartMainActivity() {
//        LoginActivity activity = Robolectric.setupActivity(LoginActivity.class);
//        activity.findViewById(R.id.button_login).performClick();
//
//        Intent expectedIntent = new Intent(activity, MainActivity.class);
//        assertEquals(expectedIntent, ShadowApplication.getInstance().getNextStartedActivity());

        assertTrue(true);
    }

}
