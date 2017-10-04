package com.appizona.yehia.movies_rx_mvp_di.application;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.appizona.yehia.movies_rx_mvp_di.di.ApplicationContextModule;
import com.appizona.yehia.movies_rx_mvp_di.di.DaggerPicassoComponent;
import com.appizona.yehia.movies_rx_mvp_di.di.PicassoComponent;

/**
 * Created by yehia on 04/10/17.
 */

public class MoviesApplication extends Application {

    private PicassoComponent component;
    private static MoviesApplication application;


    @Override
    public void onCreate() {
        super.onCreate();

        application = this;
        AndroidNetworking.initialize(getApplicationContext());

        component = DaggerPicassoComponent.builder()
                .applicationContextModule(new ApplicationContextModule(this))
                .build();

    }

    public static MoviesApplication getInstance() {
        return application;
    }

    public PicassoComponent getPicassoComponent() {
        return component;
    }
}
