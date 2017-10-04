package com.appizona.yehia.movies_rx_mvp_di.ui.movie_detail.di;

import com.appizona.yehia.movies_rx_mvp_di.ui.movie_detail.MovieDetailPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yehia on 04/10/17.
 */


@Module
public class DetailActivityModule {

    @Provides
    MovieDetailPresenter presenter() {
        return new MovieDetailPresenter();
    }

}
