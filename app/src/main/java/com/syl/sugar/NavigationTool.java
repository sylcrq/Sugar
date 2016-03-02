package com.syl.sugar;

import android.content.Context;
import android.content.Intent;

import com.syl.sugar.activity.GankActivity;
import com.syl.sugar.activity.LoginActivity;
import com.syl.sugar.activity.MainActivity;

/**
 * 统一管理Activity间跳转逻辑
 *
 * Created by syl on 16/2/4.
 */
public class NavigationTool {

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
}
