package com.example.demo.controller;

import com.example.demo.entity.Movie;
import com.example.demo.service.implementation.OMDbService;
import com.example.demo.service.implementation.TMDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private OMDbService omDbService;

    @Autowired
    private TMDService tmdService;

    @GetMapping("/movie/{id}")
    public Movie getMovieById(@PathVariable(value="id") String id){
        return tmdService.getMovieById(id);
    }

    @GetMapping("/favourite/{userId}/{movieId}")
    public Movie addMovieToFavourites(@PathVariable(value="userId") String userId, @PathVariable(value="movieId") String movieId){
        return tmdService.addMovieToFavourites(userId, movieId);
    }

    @GetMapping("/search")
    public List<Movie> getMoviesByTitle(@RequestParam(value="title") String title){
        return omDbService.getMoviesByTitle(title);
    }
}
