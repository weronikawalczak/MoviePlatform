package com.example.demo.service;

import com.example.demo.entity.Movie;

import java.util.List;

public interface MovieService {
    public Movie getMovieById(String id);
    public Movie addMovieToFavourites(String userId, String movieId);
    public List<Movie> getMoviesByTitle(String title);
}
