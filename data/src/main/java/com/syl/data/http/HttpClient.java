package com.syl.data.http;

import okhttp3.OkHttpClient;

/**
 * 封装HTTP网络请求,不依赖于底层具体实现
 * <p>
 * Created by shenyunlong on 16/4/27.
 */
public class HttpClient {

    private static OkHttpClient mInstance;

    private HttpClient() {
    }

    public static OkHttpClient getInstance() {
        if (mInstance == null) {
            mInstance = new OkHttpClient();
        }

        return mInstance;
    }

}
