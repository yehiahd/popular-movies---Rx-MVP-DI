package com.appizona.yehia.movies_rx_mvp_di.application;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

/**
 * Created by yehia on 04/10/17.
 */

public class MoviesApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
