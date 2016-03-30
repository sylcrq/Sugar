package com.syl.sugar.activity;

import com.syl.sugar.model.WelfareResponse;
import java.util.List;

/**
 * Created by shenyunlong on 3/1/16.
 */
public interface GankView {

    void showLoading();
    void hideLoading();

    void showEmptyPage();
    void hideEmptyPage();

    void showContentPage();
    void hideContentPage();

    void resetData(List<WelfareResponse.Welfare> data);
    void appendData(List<WelfareResponse.Welfare> data);

    void stopRefresh();

    void showToast(String content);
}
