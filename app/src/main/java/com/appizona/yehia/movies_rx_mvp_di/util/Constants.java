package com.appizona.yehia.movies_rx_mvp_di.util;

/**
 * Created by yehia on 04/10/17.
 */

public interface Constants {

    interface Api {
        String BASE_URL_POPULAR = "https://api.themoviedb.org/3/movie/popular";
        String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/w185/";

        interface Parameters {
            String API_KEY = "api_key";
        }
    }
}
