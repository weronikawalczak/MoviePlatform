package com.example.demo.service.implementation;

import com.example.demo.entity.SystemUser;
import com.example.demo.entity.Movie;
import com.example.demo.model.external.OMDbMovie;
import com.example.demo.repository.SystemMovieRepository;
import com.example.demo.repository.SystemUserRepository;
import com.example.demo.util.Util;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class OMDbService implements MovieService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    SystemUserRepository systemUserRepository;

    @Autowired
    SystemMovieRepository systemMovieRepository;

    @Override
    public Movie getMovieById(String id){
        String url = "http://www.omdbapi.com/?i=" + id + "&apikey=" + Util.OMDBApiKey;
        System.out.println(url);
        OMDbMovie omDbMovie = restTemplate.getForObject(url, OMDbMovie.class);
        return Movie.of(omDbMovie);
    }

    @Override
    public Movie addMovieToFavourites(String userId, String movieId) {
        Movie movie = systemMovieRepository.save(getMovieById(movieId));
        Optional<SystemUser> systemUserOptional = systemUserRepository.findById(Long.parseLong(userId));
        SystemUser systemUser = systemUserOptional.get();
        systemUser.getMovies().add(movie);
        systemUserRepository.save(systemUser);
        return null;
    }
}