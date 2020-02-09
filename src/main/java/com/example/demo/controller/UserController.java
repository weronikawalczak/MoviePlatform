package com.example.demo.controller;

import com.example.demo.entity.Movie;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/favourite/{userId}")
    public List<Movie> addMovieToFavourites(@PathVariable(value="userId") String userId){
        return userService.favouritesMovies(userId);
    }
}
