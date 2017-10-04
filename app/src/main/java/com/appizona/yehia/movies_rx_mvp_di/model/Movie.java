package com.appizona.yehia.movies_rx_mvp_di.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yehia on 04/10/17.
 */

public class Movie implements Parcelable {

    @SerializedName("vote_average")
    private String voteAverage;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("adult")
    private String adult;

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("overview")
    private String overview;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("vote_count")
    private String voteCount;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("video")
    private String video;

    @SerializedName("popularity")
    private String popularity;

    private String shortOverView;

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(String voteCount) {
        this.voteCount = voteCount;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public Movie setPosterPath(String posterPath) {
        this.posterPath = posterPath;
        return this;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getShortOverView() {
        return shortOverView;
    }

    public void setShortOverView(String shortOverView) {
        this.shortOverView = shortOverView;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.voteAverage);
        dest.writeString(this.backdropPath);
        dest.writeString(this.adult);
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.overview);
        dest.writeString(this.originalLanguage);
        dest.writeString(this.releaseDate);
        dest.writeString(this.originalTitle);
        dest.writeString(this.voteCount);
        dest.writeString(this.posterPath);
        dest.writeString(this.video);
        dest.writeString(this.popularity);
        dest.writeString(this.shortOverView);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.voteAverage = in.readString();
        this.backdropPath = in.readString();
        this.adult = in.readString();
        this.id = in.readString();
        this.title = in.readString();
        this.overview = in.readString();
        this.originalLanguage = in.readString();
        this.releaseDate = in.readString();
        this.originalTitle = in.readString();
        this.voteCount = in.readString();
        this.posterPath = in.readString();
        this.video = in.readString();
        this.popularity = in.readString();
        this.shortOverView = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
