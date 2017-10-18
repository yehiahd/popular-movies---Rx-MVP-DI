package com.appizona.yehia.movies_rx_mvp_di.ui.home;

import com.appizona.yehia.movies_rx_mvp_di.data.remote.MoviesService;
import com.appizona.yehia.movies_rx_mvp_di.ui.base.BasePresenter;
import com.appizona.yehia.movies_rx_mvp_di.util.Constants;
import com.appizona.yehia.movies_rx_mvp_di.util.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by yehia on 04/10/17.
 */

public class HomePresenter extends BasePresenter<HomeView> {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private static final String TO_BE_CONTINUED = "...";
    private static final int FIRST_INDEX_SUB = 0;
    private static final int LAST_INDEX_SUB = 80;

    @Override
    public void attachView(HomeView view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
        compositeDisposable.clear();
    }

    public void loadPopularMovies() {
        loadMovies(Constants.Api.POPULAR);
    }

    public void loadTopRatedMovies() {
        loadMovies(Constants.Api.TOP_RATED);
    }


    private void loadMovies(String MoviesType) {
        if (isViewAttached())
            MoviesService.getMovies(MoviesType)
                    .compose(RxUtils.applyNetworkSchedulers())
                    .doOnSubscribe(disposable -> {
                        getView().setLoading();
                        compositeDisposable.add(disposable);
                    })
                    .doFinally(() -> getView().setLoaded())
                    .doOnNext(response -> {
                        if (response.getMovies().size() == 0)
                            getView().showMoviesEmpty();
                    })
                    .flatMap(response -> Observable.fromIterable(response.getMovies()))
                    .map(movie -> {
                        movie.setPosterPath(Constants.Api.BASE_IMAGE_URL + movie.getPosterPath());
                        movie.setBackdropPath(Constants.Api.BASE_IMAGE_URL + movie.getBackdropPath());
                        movie.setShortOverView(movie.getOverview().substring(FIRST_INDEX_SUB, LAST_INDEX_SUB)
                                .concat(TO_BE_CONTINUED));
                        return movie;
                    })
                    .toList()
                    .subscribe(movieList -> getView().showMovies(movieList),
                            throwable -> getView().setLoadingError());

    }
}
