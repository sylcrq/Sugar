package com.syl.domain.interactor;

/**
 * 业务逻辑执行单元
 *
 * Created by shenyunlong on 4/8/16.
 */
public interface Interactor extends Runnable {

    @Override
    void run();
}
