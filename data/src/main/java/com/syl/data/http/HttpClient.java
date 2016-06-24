package com.syl.data.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * 封装HTTP网络请求,不依赖于底层具体实现
 * <p/>
 * Created by Shen YunLong on 16/4/27.
 */
public class HttpClient {

    private static OkHttpClient mInstance;

    private HttpClient() {
    }

    // 单例
    public static OkHttpClient getInstance() {
        if (mInstance == null) {
            mInstance = new OkHttpClient.Builder()
                    .connectTimeout(5, TimeUnit.SECONDS)
                    .writeTimeout(5, TimeUnit.SECONDS)
                    .readTimeout(5, TimeUnit.SECONDS)
                    .build();
        }

        return mInstance;
    }

}
