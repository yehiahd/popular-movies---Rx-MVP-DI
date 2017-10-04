package com.appizona.yehia.movies_rx_mvp_di.ui.movie_detail;

import android.content.Intent;

import com.appizona.yehia.movies_rx_mvp_di.model.Movie;
import com.appizona.yehia.movies_rx_mvp_di.ui.base.BasePresenter;
import com.appizona.yehia.movies_rx_mvp_di.util.Constants;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by yehia on 04/10/17.
 */

public class MovieDetailPresenter extends BasePresenter<MovieDetailView> {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void attachView(MovieDetailView view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        compositeDisposable.clear();
        super.detachView();
    }

    public void loadMovieDetails(Intent intent) {
        Movie movie = intent.getExtras().getParcelable(Constants.Extras.MOVIE);

        if (movie != null)
            Observable.just(movie)
                    .doOnSubscribe(disposable -> {
                        compositeDisposable.add(disposable);
                        getView().setLoading();
                    }).doFinally(() -> getView().setLoaded())
                    .subscribe(m -> getView().displayMovieDetail(m), throwable -> getView().showError(throwable.getMessage()));

    }
}
