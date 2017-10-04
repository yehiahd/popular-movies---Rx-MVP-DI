package com.appizona.yehia.movies_rx_mvp_di.ui.base;

/**
 * Created by yehia on 04/10/17.
 */

public class BasePresenter<V extends BaseView> implements Presenter<V> {

    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    public V getView() {
        return view;
    }

    public boolean isViewAttached() {
        return view != null;
    }

}
