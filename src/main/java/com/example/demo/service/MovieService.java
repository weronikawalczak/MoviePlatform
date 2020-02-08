package com.example.demo.service;

import com.example.demo.entity.Movie;

public interface MovieService {
    public Movie getMovieById(String id);
    public Movie addMovieToFavourites(String userId, String movieId);
}
