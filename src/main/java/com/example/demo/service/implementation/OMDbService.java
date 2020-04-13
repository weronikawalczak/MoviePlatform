package com.example.demo.service.implementation;

import com.example.demo.entity.SystemUser;
import com.example.demo.entity.Movie;
import com.example.demo.model.external.OMDbMovie;
import com.example.demo.model.external.OMDbMovieSearch;
import com.example.demo.model.external.TMDMovie;
import com.example.demo.model.external.TMDMovieSearch;
import com.example.demo.repository.SystemMovieRepository;
import com.example.demo.repository.SystemUserRepository;
import com.example.demo.util.Util;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OMDbService implements MovieService {
    private RestTemplate restTemplate;
    private SystemUserRepository systemUserRepository;
    private SystemMovieRepository systemMovieRepository;

    public OMDbService(RestTemplate restTemplate, SystemUserRepository systemUserRepository, SystemMovieRepository systemMovieRepository) {
        this.restTemplate = restTemplate;
        this.systemUserRepository = systemUserRepository;
        this.systemMovieRepository = systemMovieRepository;
    }

    @Override
    public Movie getMovieById(Long id){
        String url = "http://www.omdbapi.com/?i=" + id + "&apikey=" + Util.OMDBApiKey;
        System.out.println(url);
        OMDbMovie omDbMovie = restTemplate.getForObject(url, OMDbMovie.class);
        return Movie.of(omDbMovie);
    }

    @Override
    public Movie addMovieToFavourites(Long userId, Long movieId) {
        Movie movie = systemMovieRepository.save(getMovieById(movieId));
        Optional<SystemUser> systemUserOptional = systemUserRepository.findById(userId);
        SystemUser systemUser = systemUserOptional.get();
        systemUser.getFavourites().add(movie);
        systemUserRepository.save(systemUser);
        return null;
    }

    @Override
    public List<Movie> getMoviesByTitle(String title) {
        String url = "http://www.omdbapi.com/?t=" + title + "&apikey=" + Util.OMDBApiKey;
        System.out.println(url);

        OMDbMovie response = restTemplate.getForObject(url, OMDbMovie.class);

        OMDbMovieSearch omDbMovieSearch = new OMDbMovieSearch();
        List<OMDbMovie> omDbMovies = new ArrayList<>();
        omDbMovies.add(response);

        List<Movie> movies = new ArrayList<>();

        for (OMDbMovie omDbMovie: omDbMovies) {
            movies.add(Movie.of(omDbMovie));
        }
        return movies;
    }

    @Override
    public void addMovieToWatch(Long movieId, Long userId) {

    }


}



