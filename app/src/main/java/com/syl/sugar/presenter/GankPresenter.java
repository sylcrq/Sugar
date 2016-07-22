package com.syl.sugar.presenter;


import com.syl.sugar.view.GankView;


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

    public void loadData(final int page, final boolean refresh) {
        if (!refresh && page == 1) {
            // 首次进入页面
            startLoading();
        }

        final String url = "http://gank.io/api/data/福利/10/" + page;

//        HttpUtil.getInstance().get(url, new HttpCallback<WelfareResponse>(WelfareResponse.class) {
//            @Override
//            public void onFailure(Response response, IOException e) {
//                if (refresh) {
        // 下拉刷新失败
//                    mGankView.stopRefresh();
//                    mGankView.showToast("Refresh Error");
//                } else if (page > 1) {
        // 加载下一页失败
//                    mGankView.showToast("LoadMore Error");
//                } else {
//                    showErrorPage();
//                }
//
//                EventBus.getDefault().post(new MessageEvent("Error From EventBus"));
//            }
//
//            @Override
//            public void onSuccess(WelfareResponse response) {
//                if (refresh) {
        // 下拉刷新成功
//                    mGankView.stopRefresh();
//                    mGankView.resetData(response.getResults());
//                } else if (page > 1) {
        // 加载下一页成功
//                    mGankView.appendData(response.getResults());
//                } else {
//                    mGankView.resetData(response.getResults());
//                }
//                showResultData();
//
//                EventBus.getDefault().post(new MessageEvent("OK From EventBus"));
//            }
//
//            @Override
//            public WelfareResponse parse(Reader json, Class<WelfareResponse> classOfT) {
//                return SugarJson.fromJson(json, classOfT);
//            }
//        });
    }
}
