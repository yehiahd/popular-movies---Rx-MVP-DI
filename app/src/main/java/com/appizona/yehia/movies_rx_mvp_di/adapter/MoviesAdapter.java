package com.appizona.yehia.movies_rx_mvp_di.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appizona.yehia.movies_rx_mvp_di.R;
import com.appizona.yehia.movies_rx_mvp_di.calllback.OnMovieClickListener;
import com.appizona.yehia.movies_rx_mvp_di.model.Movie;
import com.appizona.yehia.movies_rx_mvp_di.util.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yehia on 04/10/17.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesHolder> {

    private Context mContext;
    private List<Movie> list;
    private Picasso picasso;
    private OnMovieClickListener onMovieClickListener;

    @Inject
    public MoviesAdapter(Context context, List<Movie> list, Picasso picasso) {
        this.mContext = context;
        this.list = list;
        this.picasso = picasso;
    }

    public void setOnMovieClickListener(OnMovieClickListener onMovieClickListener) {
        this.onMovieClickListener = onMovieClickListener;
    }

    public void updateAdapter(List<Movie> movies) {
        this.list.clear();
        this.list.addAll(movies);
        this.notifyDataSetChanged();
    }

    @Override
    public MoviesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MoviesHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(MoviesHolder holder, int position) {
        Movie movie = list.get(position);

        picasso.load(movie.getPosterPath())
                .placeholder(R.drawable.progress_placeholder)
                .transform(new CircleTransform())
                .into(holder.poster);

        holder.title.setText(movie.getTitle());
        holder.overView.setText(movie.getShortOverView());

        holder.root.setOnClickListener(view -> onMovieClickListener.onMovieClicked(movie));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MoviesHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.movie_poster)
        ImageView poster;
        @BindView(R.id.movie_title)
        TextView title;
        @BindView(R.id.movie_over_view)
        TextView overView;
        @BindView(R.id.root)
        LinearLayout root;


        public MoviesHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
