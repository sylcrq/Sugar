package com.syl.sugar;

import android.os.Handler;
import android.os.Looper;
import com.google.gson.Gson;
import com.syl.aop.annotation.DebugTrace;
import com.syl.sugar.model.Welfare;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

                final List<Welfare> data = new ArrayList<Welfare>();

                try {
                    JSONObject jsonObj = new JSONObject(response.body().string());

                    JSONArray jsonArray = jsonObj.optJSONArray("results");
                    if(jsonArray != null) {
                        for(int i=0; i<jsonArray.length(); i++) {
                            JSONObject obj = jsonArray.getJSONObject(i);

                            Welfare welfare = new Welfare();
                            welfare.setUrl(obj.getString("url"));
                            data.add(welfare);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mGankView.bindData(data);
                        showResultData();
                    }
                });
            }
        });
    }
}
