package com.example.demo.controller;

import com.example.demo.entity.Movie;
import com.example.demo.service.implementation.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void register(@RequestParam String email, @RequestParam String password){
        userService.register(email, password);
    }

    @GetMapping("/favourite/{userId}")
    public List<Movie> addMovieToFavourites(@PathVariable(value="userId") String userId){
        return userService.favouritesMovies(userId);
    }
}
