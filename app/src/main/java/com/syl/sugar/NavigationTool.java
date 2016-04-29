package com.syl.sugar;

import android.content.Context;
import android.content.Intent;

import com.syl.sugar.view.activity.BlankActivity;
import com.syl.sugar.view.activity.GankActivity;
import com.syl.sugar.view.activity.LoginActivity;
import com.syl.sugar.view.activity.MainActivity;
import com.syl.sugar.view.activity.MeiziActivity;
import com.syl.sugar.view.activity.SingleUserActivity;

/**
 * 统一管理Activity间跳转逻辑
 * <p>
 * Created by syl on 16/2/4.
 */
public class NavigationTool {

    public static final String START_MEIZI_KEY_IMAGE_URL = "START_MEIZI_KEY_IMAGE_URL";
    public static final String START_SINGLE_USER_KEY_NAME = "START_SINGLE_USER_KEY_NAME";

    public static void gotoMainActivity(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        }
    }

    public static void gotoLoginActivity(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, LoginActivity.class);
            context.startActivity(intent);
        }
    }

    public static void gotoGankActivity(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, GankActivity.class);
            context.startActivity(intent);
        }
    }

    public static void gotoBlankActivity(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, BlankActivity.class);
            context.startActivity(intent);
        }
    }

    public static void gotoMeiziActivity(Context context, String url) {
        if (context != null) {
            Intent intent = new Intent(context, MeiziActivity.class);
            intent.putExtra(START_MEIZI_KEY_IMAGE_URL, url);
            context.startActivity(intent);
        }
    }

    public static void gotoSingleUserActivity(Context context, String userName) {
        if (context != null) {
            Intent intent = new Intent(context, SingleUserActivity.class);
            intent.putExtra(START_SINGLE_USER_KEY_NAME, userName);
            context.startActivity(intent);
        }
    }
}
