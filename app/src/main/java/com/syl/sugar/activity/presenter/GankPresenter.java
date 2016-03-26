package com.syl.sugar.activity.presenter;

import com.syl.sugar.activity.GankView;
import com.syl.sugar.http.HttpCallback;
import com.syl.sugar.http.HttpUtil;
import com.syl.sugar.model.WelfareResponse;
import com.syl.sugar.utils.GsonUtil;
import java.io.IOException;
import java.io.Reader;

import okhttp3.Response;

/**
 * Created by shenyunlong on 3/1/16.
 */
public class GankPresenter {

    private GankView mGankView;

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

        HttpUtil.getInstance().get(url, new HttpCallback<WelfareResponse>(WelfareResponse.class) {
            @Override
            public void onFailure(Response response, IOException e) {
                showErrorPage();
            }

            @Override
            public void onSuccess(WelfareResponse response) {
                mGankView.bindData(response.getResults());
                showResultData();
            }

            @Override
            public WelfareResponse parse(Reader json, Class<WelfareResponse> classOfT) {
                return GsonUtil.getGson().fromJson(json, classOfT);
            }
        });
    }
}
