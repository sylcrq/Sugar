package com.syl.sugar.http;

import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

/**
 * 封装OkHttp网络请求
 *
 * Created by shenyunlong on 3/26/16.
 */
public class HttpUtil {

    public static final String HTTP_GET = "GET";
    public static final String HTTP_POST = "POST";

    private OkHttpClient mOkHttpClient = new OkHttpClient();
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* 单例 */
    private static HttpUtil mInstance;

    private HttpUtil() {
    }

    public synchronized static HttpUtil getInstance() {
        if(mInstance == null) {
            mInstance = new HttpUtil();
        }

        return mInstance;
    }

    public <T> void get(String url, HttpCallback<T> callback) {
        call(HTTP_GET, url, callback);
    }

    public <T> void post(String url, HttpCallback<T> callback) {
        call(HTTP_POST, url, callback);
    }

    private <T> void call(String method, String url, final HttpCallback<T> callback) {

        final Request request = new Request.Builder()
                .url(url)
                .method(method, method.equals(HTTP_GET) ? null : new RequestBody() {
                    @Override
                    public MediaType contentType() {
                        return null;
                    }

                    @Override
                    public void writeTo(BufferedSink sink) throws IOException {

                    }
                })
                .build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onFailure(null, e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if(!response.isSuccessful()) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFailure(response, null);
                        }
                    });

                    return;
                }

                final T t = callback.parse(response.body().charStream(), callback.getClassOfT());

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(t);
                    }
                });

            }
        });
    }

}
