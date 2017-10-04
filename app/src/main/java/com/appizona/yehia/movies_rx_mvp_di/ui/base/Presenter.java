package com.appizona.yehia.movies_rx_mvp_di.ui.base;

/**
 * Created by yehia on 04/10/17.
 */

public interface Presenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}
