package com.example.demo.util;

import com.example.demo.entity.Movie;
import com.example.demo.model.*;
import com.example.demo.model.external.OMDbMovie;
import com.example.demo.model.external.OMDbRating;
import com.example.demo.model.external.TMDMovie;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static Movie convert(OMDbMovie omDbMovie){
        Movie movie = new Movie();
        List<Rating> ratings = new ArrayList<>();

        movie.setTitle(omDbMovie.getTitle());
        movie.setYear(omDbMovie.getYear());
        movie.setExternalID(omDbMovie.getImdbID());

        for (OMDbRating omDbRating: omDbMovie.getRatings()) {
            ratings.add(Rating.of(omDbRating));
        }

        ratings.add(new Rating(OMDbMovie.sourceName, omDbMovie.getImdbRating()));
        movie.setRatings(ratings);
        return movie;
    }

    public static Movie convert(TMDMovie theMovieMovie){
        Movie movie = new Movie();
        List<Rating> ratings = new ArrayList<>();

        movie.setTitle(theMovieMovie.getTitle());
        movie.setYear(theMovieMovie.getYear());
        movie.setExternalID(theMovieMovie.getId());

        ratings.add(new Rating(theMovieMovie.sourceName, theMovieMovie.getVoteAverage()));
        movie.setRatings(ratings);
        return movie;
    }
}
