package com.example.movieapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class DetailsActivity extends AppCompatActivity {

    Context context;
    private Movie clickedMovie;

    @Override
    protected void onCreate(Bundle savedInstanveState) {
        super.onCreate(savedInstanveState);
        setContentView(R.layout.movie_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        clickedMovie = intent.getParcelableExtra("movie");

        if (clickedMovie != null) {
            ImageView filmPoster = (ImageView) findViewById(R.id.iv_movie_poster);
            Picasso.with(context).load(clickedMovie.getFilmPoster()).into(filmPoster);

            TextView title = (TextView) findViewById(R.id.tv_title);
            title.setText(clickedMovie.getFilmTitle());

            TextView release = (TextView) findViewById(R.id.tv_release_date);
            release.setText(clickedMovie.getReleaseDate());

            TextView voteAverage = (TextView) findViewById(R.id.tv_average);
            voteAverage.setText(Double.toString(clickedMovie.getVoteAverage()));

            TextView plot = (TextView) findViewById(R.id.tv_plot);
            plot.setText(clickedMovie.getPlot());
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}
