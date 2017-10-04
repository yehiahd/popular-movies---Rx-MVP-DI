package com.appizona.yehia.movies_rx_mvp_di.ui.home;

import com.appizona.yehia.movies_rx_mvp_di.model.Movie;
import com.appizona.yehia.movies_rx_mvp_di.ui.base.BaseView;

import java.util.List;

/**
 * Created by yehia on 04/10/17.
 */

public interface HomeView extends BaseView {

    void showMovies(List<Movie> movies);

    void showMoviesEmpty();

    void setLoadingError();

}
