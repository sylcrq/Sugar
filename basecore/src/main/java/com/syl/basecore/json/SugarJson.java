package com.syl.basecore.json;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.Reader;
import java.lang.reflect.Type;

/**
 * 封装JSON和Java对象转换接口
 * <p>
 * Created by Shen YunLong on 2016/05/12.
 */
public class SugarJson {

    private static Gson mGson = new Gson();

    /**
     * deserialization
     *
     * @param json
     * @param classOfT
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json, Class<T> classOfT) {
        return mGson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(String json, Type typeOfT) {
        return mGson.fromJson(json, typeOfT);
    }

    public static <T> T fromJson(Reader json, Class<T> classOfT) {
        return mGson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(Reader json, Type typeOfT) {
        return mGson.fromJson(json, typeOfT);
    }

    public static <T> T fromJson(JsonElement json, Class<T> classOfT) {
        return mGson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(JsonElement json, Type typeOfT) {
        return mGson.fromJson(json, typeOfT);
    }

    /**
     * serialization
     *
     * @param src
     * @param typeOfSrc
     * @return
     */
    public static String toJson(Object src, Type typeOfSrc) {
        return mGson.toJson(src, typeOfSrc);
    }
}
