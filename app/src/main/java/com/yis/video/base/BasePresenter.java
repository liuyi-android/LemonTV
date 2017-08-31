package com.yis.video.base;

/**
 * Created by yis on 2017/8/18.
 */
public interface BasePresenter<T> {
    void attachView(T view);

    void detachView();
}
