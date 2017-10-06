package com.appizona.yehia.movies_rx_mvp_di.data.remote;

import com.appizona.yehia.movies_rx_mvp_di.BuildConfig;
import com.appizona.yehia.movies_rx_mvp_di.model.MoviesServiceResponse;
import com.appizona.yehia.movies_rx_mvp_di.util.Constants;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import io.reactivex.Observable;

/**
 * Created by yehia on 04/10/17.
 */

public class MoviesService {

    public static Observable<MoviesServiceResponse> getMovies(String MoviesType) {
        return Rx2AndroidNetworking.get(Constants.Api.BASE_URL + MoviesType)
                .addQueryParameter(Constants.Api.Parameters.API_KEY, BuildConfig.MOVIE_DB_API_TOKEN)
                .build()
                .getObjectObservable(MoviesServiceResponse.class);
    }
}
