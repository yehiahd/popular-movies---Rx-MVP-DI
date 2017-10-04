package com.appizona.yehia.movies_rx_mvp_di.ui.home.di;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.appizona.yehia.movies_rx_mvp_di.adapter.MoviesAdapter;
import com.appizona.yehia.movies_rx_mvp_di.di.ContextModule;
import com.appizona.yehia.movies_rx_mvp_di.ui.home.HomePresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yehia on 04/10/17.
 */

@Module(includes = ContextModule.class)
public class HomeActivityModule {

    @Provides
    MoviesAdapter moviesAdapter(Context context, Picasso picasso) {
        return new MoviesAdapter(context, new ArrayList<>(), picasso);
    }

    @Provides
    HomePresenter homePresenter() {
        return new HomePresenter();
    }

    @Provides
    RecyclerView.LayoutManager manager(Context context) {
        return new LinearLayoutManager(context);
    }

    @Provides
    Intent intent() {
        return new Intent();
    }
}
