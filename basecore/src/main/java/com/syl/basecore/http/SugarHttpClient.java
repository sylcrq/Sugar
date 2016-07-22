package com.syl.basecore.http;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * HTTP请求工具类
 * <p/>
 * Created by Shen YunLong on 2016/07/22.
 */
public class SugarHttpClient {

    private static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 5;
    private static final int DEFAULT_HTTP_WRITE_TIMEOUT = 5;
    private static final int DEFAULT_HTTP_READ_TIMEOUT = 5;

    private OkHttpClient mOkHttpClient;

    private static SugarHttpClient sInstance;

    private SugarHttpClient() {
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_HTTP_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    public synchronized static SugarHttpClient getInstance() {
        if (sInstance == null) {
            sInstance = new SugarHttpClient();
        }

        return sInstance;
    }

    /**
     * HTTP GET请求
     *
     * @param url
     * @param callback
     * @throws Exception
     */
    public void doHttpGet(String url, final HttpCallback callback) {
        Request request = new Request.Builder().url(url).build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (callback != null) {
                    callback.onError(e);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }

                if (callback != null) {
                    callback.onSuccess(response.body().string());
                }
            }
        });
    }

    public interface HttpCallback {
        void onError(IOException e);

        void onSuccess(String response);
    }
}
