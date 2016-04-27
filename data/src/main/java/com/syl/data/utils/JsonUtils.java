package com.syl.data.utils;

import com.google.gson.Gson;

import java.io.Reader;
import java.lang.reflect.Type;

/**
 * JSON与Java对象转换
 * <p>
 * Created by shenyunlong on 16/4/27.
 */
public class JsonUtils {

    private static Gson mGson = new Gson();

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return mGson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(Reader json, Class<T> classOfT) {
        return mGson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(String json, Type typeOfT) {
        return mGson.fromJson(json, typeOfT);
    }

    public static <T> T fromJson(Reader json, Type typeOfT) {
        return mGson.fromJson(json, typeOfT);
    }
}
