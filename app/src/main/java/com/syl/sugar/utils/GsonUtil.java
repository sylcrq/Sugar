package com.syl.sugar.utils;

import com.google.gson.Gson;

/**
 * Created by shenyunlong on 3/26/16.
 */
public class GsonUtil {

    private static Gson sGson = new Gson();

    public static Gson getGson() {
        return sGson;
    }

}
