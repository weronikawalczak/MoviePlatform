package com.example.demo.service.implementation;

import com.example.demo.entity.Movie;
import com.example.demo.entity.SystemUser;
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
public class TMDService implements MovieService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    SystemMovieRepository systemMovieRepository;

    @Autowired
    SystemUserRepository systemUserRepository;

    @Override
    public Movie getMovieById(String id) {
        String url = "https://api.themoviedb.org/3/movie/" + id + "?api_key=" + Util.TheMovieApiKey;
        System.out.println(url);
        TMDMovie tmdMovie = restTemplate.getForObject(url, TMDMovie.class);
        return Movie.of(tmdMovie);
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



    //        ResponseEntity<TMDMovie[]> response =
//                restTemplate.getForEntity(url, TMDMovie[].class);
//        TMDMovie[] tmdMovies = response.getBody();


}






