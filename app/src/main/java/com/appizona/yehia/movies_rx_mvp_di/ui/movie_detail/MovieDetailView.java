package com.appizona.yehia.movies_rx_mvp_di.ui.movie_detail;

import com.appizona.yehia.movies_rx_mvp_di.model.Movie;
import com.appizona.yehia.movies_rx_mvp_di.ui.base.BaseView;

/**
 * Created by yehia on 04/10/17.
 */

public interface MovieDetailView extends BaseView {

    void displayMovieDetail(Movie movie);

    void showError(String message);

}
