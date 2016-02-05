package com.syl.sugar;

import android.content.Context;
import android.content.Intent;

/**
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
}
