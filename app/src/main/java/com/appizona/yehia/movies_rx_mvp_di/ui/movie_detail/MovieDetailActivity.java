package com.appizona.yehia.movies_rx_mvp_di.ui.movie_detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.appizona.yehia.movies_rx_mvp_di.R;
import com.appizona.yehia.movies_rx_mvp_di.application.MoviesApplication;
import com.appizona.yehia.movies_rx_mvp_di.databinding.ActivityMovieDetailBinding;
import com.appizona.yehia.movies_rx_mvp_di.model.Movie;
import com.appizona.yehia.movies_rx_mvp_di.ui.base.BaseActivity;
import com.appizona.yehia.movies_rx_mvp_di.ui.movie_detail.di.DaggerDetailActivityComponent;
import com.appizona.yehia.movies_rx_mvp_di.util.CircleTransform;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailActivity extends BaseActivity implements MovieDetailView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Inject
    MovieDetailPresenter presenter;

    @Inject
    Picasso picasso;

    private ActivityMovieDetailBinding activityMovieDetailBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMovieDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail);
        ButterKnife.bind(this);

        DaggerDetailActivityComponent.builder()
                .picassoComponent(MoviesApplication.getInstance().getPicassoComponent())
                .build()
                .inject(this);

        initUI();
    }

    private void initUI() {
        setSupportActionBar(toolbar);
        presenter.attachView(this);
        presenter.loadMovieDetails(getIntent());
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
    public void displayMovieDetail(Movie movie) {
        activityMovieDetailBinding.setMovie(movie);

        picasso.load(movie.getPosterPath())
                .placeholder(R.drawable.progress_placeholder)
                .transform(new CircleTransform())
                .into(activityMovieDetailBinding.moviePoster);

        picasso.load(movie.getBackdropPath())
                .placeholder(R.drawable.background)
                .into(activityMovieDetailBinding.movieCover);

    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
