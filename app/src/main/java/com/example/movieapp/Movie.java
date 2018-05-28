package com.example.movieapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
    //Variables - title, release date, poster and vote average
    String filmTitle;
    String releaseDate;
    String filmPoster;
    double voteAverage;
    String plot;


    // Constructor
    String MOVIE_IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w185";

    public Movie(String movieTitle, String releaseDate, String moviePoster, double voteAverage, String plotSynopsis) {

        this.filmTitle = movieTitle;
        this.releaseDate = releaseDate;
        this.filmPoster = moviePoster;
        this.voteAverage = voteAverage;
        this.plot = plotSynopsis;

    }

    /**
     * Constructor
     *
     * @param position
     */
    public Movie(int position) {
    }

    public Movie(Parcel in) {
        filmTitle = in.readString();
        releaseDate = in.readString();
        filmPoster = in.readString();
        voteAverage = in.readDouble();
        plot = in.readString();

    }

    //Setter and Getter methods
    public String getFilmTitle() {
        return this.filmTitle;
    }

    public void setFilmTitle() {
        this.filmTitle = filmTitle;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate() {
        this.releaseDate = releaseDate;
    }

    public String getFilmPoster() {
        return MOVIE_IMAGE_BASE_URL + this.filmPoster;
    }

    public void setFilmPoster() {
        this.filmPoster = filmPoster;
    }

    public double getVoteAverage() {
        return this.voteAverage;
    }

    public void setVoteAverage() {
        this.voteAverage = voteAverage;
    }

    public String getPlot() {
        return this.plot;
    }

    public void setPlot() {
        this.plot = plot;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(filmTitle);
        dest.writeString(releaseDate);
        dest.writeString(filmPoster);
        dest.writeDouble(voteAverage);
        dest.writeString(plot);

    }
}