package com.appizona.yehia.movies_rx_mvp_di.ui.home.di;

import com.appizona.yehia.movies_rx_mvp_di.di.PicassoComponent;
import com.appizona.yehia.movies_rx_mvp_di.ui.home.HomeActivity;

import dagger.Component;

/**
 * Created by yehia on 04/10/17.
 */

@Component(modules = HomeActivityModule.class, dependencies = PicassoComponent.class)
public interface HomeActivityComponent {
    void inject(HomeActivity homeActivity);
}
