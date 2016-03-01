package com.syl.sugar;

import android.os.Handler;
import android.os.Looper;
import com.google.gson.Gson;
import com.syl.aop.annotation.DebugTrace;
import com.syl.sugar.model.WelfareResp;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by shenyunlong on 3/1/16.
 */
public class GankPresenter {

    private GankView mGankView;

    private static final OkHttpClient sClient = new OkHttpClient();
    private static final Gson mGson = new Gson();

    public GankPresenter(GankView gankView) {
        mGankView = gankView;
    }

    private void startLoading() {
        mGankView.hideContentPage();
        mGankView.hideEmptyPage();
        mGankView.showLoading();
    }

    private void showResultData() {
        mGankView.hideLoading();
        mGankView.hideEmptyPage();
        mGankView.showContentPage();
    }

    private void showErrorPage() {
        mGankView.hideLoading();
        mGankView.hideContentPage();
        mGankView.showEmptyPage();
    }

    public void loadData() {
        startLoading();

        final String url = "http://gank.io/api/data/福利/10/1";
        final Request request = new Request.Builder().url(url).build();

        final Handler handler = new Handler(Looper.getMainLooper());

        sClient.newCall(request).enqueue(new Callback() {
            @DebugTrace
            @Override
            public void onFailure(Call call, IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        showErrorPage();
                    }
                });
            }

            @DebugTrace
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(!response.isSuccessful()) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            showErrorPage();
                        }
                    });
                    return;
                }

                final WelfareResp resp = mGson.fromJson(response.body().charStream(), WelfareResp.class);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mGankView.bindData(resp.getResults());
                        showResultData();
                    }
                });
            }
        });
    }
}
