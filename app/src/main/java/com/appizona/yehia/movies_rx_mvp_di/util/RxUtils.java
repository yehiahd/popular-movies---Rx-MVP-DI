package com.appizona.yehia.movies_rx_mvp_di.util;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yehia on 18/10/17.
 */


public class RxUtils {

    public static <T> ObservableTransformer<T, T> applyNetworkSchedulers() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
