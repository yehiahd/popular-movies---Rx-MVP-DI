package com.appizona.yehia.movies_rx_mvp_di.ui.movie_detail.di;

import com.appizona.yehia.movies_rx_mvp_di.di.PicassoComponent;
import com.appizona.yehia.movies_rx_mvp_di.ui.movie_detail.MovieDetailActivity;

import dagger.Component;

/**
 * Created by yehia on 04/10/17.
 */

@Component(modules = DetailActivityModule.class, dependencies = PicassoComponent.class)
public interface DetailActivityComponent {

    void inject(MovieDetailActivity movieDetailActivity);
}
