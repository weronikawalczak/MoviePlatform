package com.example.demo.service.implementation;

import com.example.demo.model.Movie;
import com.example.demo.model.external.OMDbMovie;
import com.example.demo.util.Util;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OMDbService implements MovieService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Movie getMovieById(String id){
        String url = "http://www.omdbapi.com/?i=" + id + "&apikey=" + Util.OMDBApiKey;
        OMDbMovie omDbMovie = restTemplate.getForObject(url, OMDbMovie.class);
        return Movie.of(omDbMovie);
    }
}





//    @Override
//    public Movie getMovieById(Integer id) {
//        String url = "http://www.omdbapi.com/?t=" + id + "&apikey=" + Util.OMDBApiKey;
//        return restTemplate.getForObject(url, Movie.class);
//    }