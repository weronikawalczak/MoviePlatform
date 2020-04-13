package com.example.demo.service;

import com.example.demo.entity.Movie;

import java.util.List;

public interface MovieService {
    Movie getMovieById(Long id);
    Movie addMovieToFavourites(Long userId, Long movieId);
    List<Movie> getMoviesByTitle(String title);
    void addMovieToWatch(Long movieId, Long userId);
}
