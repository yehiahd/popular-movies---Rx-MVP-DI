package com.appizona.yehia.movies_rx_mvp_di.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.appizona.yehia.movies_rx_mvp_di.R;
import com.appizona.yehia.movies_rx_mvp_di.adapter.MoviesAdapter;
import com.appizona.yehia.movies_rx_mvp_di.application.MoviesApplication;
import com.appizona.yehia.movies_rx_mvp_di.calllback.OnMovieClickListener;
import com.appizona.yehia.movies_rx_mvp_di.di.ContextModule;
import com.appizona.yehia.movies_rx_mvp_di.model.Movie;
import com.appizona.yehia.movies_rx_mvp_di.ui.base.BaseActivity;
import com.appizona.yehia.movies_rx_mvp_di.ui.home.di.DaggerHomeActivityComponent;
import com.appizona.yehia.movies_rx_mvp_di.ui.movie_detail.MovieDetailActivity;
import com.appizona.yehia.movies_rx_mvp_di.util.Constants;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements HomeView, OnMovieClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_movies)
    RecyclerView recyclerMovies;
    @BindView(R.id.failed_to_load_TV)
    TextView failedToLoadTV;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.no_data_to_show)
    TextView noDataToShowTV;

    @Inject
    MoviesAdapter adapter;

    @Inject
    HomePresenter presenter;

    @Inject
    RecyclerView.LayoutManager manager;

    @Inject
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        DaggerHomeActivityComponent.builder()
                .contextModule(new ContextModule(this))
                .picassoComponent(MoviesApplication.getInstance().getPicassoComponent())
                .build().inject(this);

        initUI();
    }

    private void initUI() {
        setSupportActionBar(toolbar);

        adapter.setOnMovieClickListener(this);

        recyclerMovies.setLayoutManager(manager);
        recyclerMovies.setAdapter(adapter);

        presenter.attachView(this);
        presenter.loadPopularMovies();
    }

    @Override
    public void setLoading() {
        showViews(progressBar);
    }

    @Override
    public void setLoaded() {
        hideViews(progressBar);
    }

    @Override
    public void showMovies(List<Movie> movies) {
        adapter.updateAdapter(movies);
    }

    @Override
    public void showMoviesEmpty() {
        showViews(noDataToShowTV);
    }

    @Override
    public void setLoadingError() {
        showViews(failedToLoadTV);
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    @Override
    public void onMovieClicked(Movie movie) {
        intent.setClass(this, MovieDetailActivity.class);
        intent.putExtra(Constants.Extras.MOVIE, movie);
        startActivity(intent);
    }
}
