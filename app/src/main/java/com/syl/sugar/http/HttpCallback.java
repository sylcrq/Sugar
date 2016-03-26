package com.syl.sugar.http;

import java.io.IOException;
import java.io.Reader;
import okhttp3.Response;

/**
 * Created by shenyunlong on 3/26/16.
 */
public abstract class HttpCallback<T> {

    private final Class<T> mClassOfT;

    public HttpCallback(Class<T> classOfT) {
        mClassOfT = classOfT;
    }

    public Class<T> getClassOfT() {
        return mClassOfT;
    }

    public abstract void onFailure(Response response, IOException e);

    public abstract void onSuccess(T t);

    public abstract T parse(Reader json, Class<T> classOfT);
}
