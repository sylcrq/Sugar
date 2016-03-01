package com.syl.sugar;

import com.syl.sugar.model.Welfare;
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

    void bindData(List<Welfare> welfares);
}
