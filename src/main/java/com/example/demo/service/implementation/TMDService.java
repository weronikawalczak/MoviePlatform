package com.example.demo.service.implementation;

import com.example.demo.entity.Movie;
import com.example.demo.entity.SystemUser;
import com.example.demo.model.external.TMDMovie;
import com.example.demo.model.external.TMDMovieSearch;
import com.example.demo.repository.SystemMovieRepository;
import com.example.demo.repository.SystemUserRepository;
import com.example.demo.util.Util;
import com.example.demo.service.MovieService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TMDService implements MovieService {
    private RestTemplate restTemplate;
    private SystemMovieRepository systemMovieRepository;
    private SystemUserRepository systemUserRepository;

    public TMDService(RestTemplate restTemplate, SystemMovieRepository systemMovieRepository, SystemUserRepository systemUserRepository) {
        this.restTemplate = restTemplate;
        this.systemMovieRepository = systemMovieRepository;
        this.systemUserRepository = systemUserRepository;
    }

    @Override
    public Movie getMovieById(Long id) {
        String url = "https://api.themoviedb.org/3/movie/" + id + "?api_key=" + Util.TheMovieApiKey;
        System.out.println(url);
        TMDMovie tmdMovie = restTemplate.getForObject(url, TMDMovie.class);
        return Movie.of(tmdMovie);
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
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + Util.TheMovieApiKey + "&query=" + title;
        System.out.println(url);

        TMDMovieSearch response = restTemplate.getForObject(url, TMDMovieSearch.class);

        List<Movie> movies = new ArrayList<>();

        for (TMDMovie tmdMovie: response.getTmdMovies()) {
            movies.add(Movie.of(tmdMovie));
        }
        return movies;
    }

    @Override
    public void addMovieToWatch(Long movieId, Long userId) {
        try {
            Movie movie = systemMovieRepository.save(getMovieById(movieId));
            Optional<SystemUser> systemUserOptional = systemUserRepository.findById(userId);
            SystemUser systemUser = systemUserOptional.get();
            systemUser.getToWatch().add(movie);
            systemUserRepository.save(systemUser);
        }catch (Exception e){
            //TODO Movie not found exception

        }
    }
}






