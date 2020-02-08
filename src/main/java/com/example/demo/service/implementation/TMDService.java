package com.example.demo.service.implementation;

import com.example.demo.model.Movie;
import com.example.demo.model.external.TMDMovie;
import com.example.demo.util.Util;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class TMDService implements MovieService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Movie getMovieById(String id) {
        String url = "https://api.themoviedb.org/3/movie/" + id + "?api_key=" + Util.TheMovieApiKey;
        TMDMovie tmdMovie = restTemplate.getForObject(url, TMDMovie.class);
        return Movie.of(tmdMovie);
    }
}






