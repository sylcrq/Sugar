package com.syl.sugar;

import android.content.Context;
import android.content.Intent;

import com.syl.sugar.activity.BlankActivity;
import com.syl.sugar.activity.GankActivity;
import com.syl.sugar.activity.LoginActivity;
import com.syl.sugar.activity.MainActivity;
import com.syl.sugar.activity.MeiziActivity;

/**
 * 统一管理Activity间跳转逻辑
 *
 * Created by syl on 16/2/4.
 */
public class NavigationTool {

    public static final String START_MEIZI_KEY_IMAGE_URL = "START_MEIZI_KEY_IMAGE_URL";

    public static void gotoMainActivity(Context context) {
        if(context != null) {
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        }
    }

    public static void gotoLoginActivity(Context context) {
        if(context != null) {
            Intent intent = new Intent(context, LoginActivity.class);
            context.startActivity(intent);
        }
    }

    public static void gotoGankActivity(Context context) {
        if(context != null) {
            Intent intent = new Intent(context, GankActivity.class);
            context.startActivity(intent);
        }
    }

    public static void gotoBlankActivity(Context context) {
        if(context != null) {
            Intent intent = new Intent(context, BlankActivity.class);
            context.startActivity(intent);
        }
    }

    public static void gotoMeiziActivity(Context context, String url) {
        if(context != null) {
            Intent intent = new Intent(context, MeiziActivity.class);
            intent.putExtra(START_MEIZI_KEY_IMAGE_URL, url);
            context.startActivity(intent);
        }
    }
}
