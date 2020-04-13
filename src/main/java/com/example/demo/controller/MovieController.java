package com.example.demo.controller;

import com.example.demo.entity.Movie;
import com.example.demo.entity.SystemUser;
import com.example.demo.service.implementation.OMDbService;
import com.example.demo.service.implementation.TMDService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class MovieController {
    private OMDbService omDbService;
    private TMDService tmdService;

    public MovieController(OMDbService omDbService, TMDService tmdService) {
        this.omDbService = omDbService;
        this.tmdService = tmdService;
    }

    @GetMapping
    public String getDefault(){
        return "Hello from MovieController";
    }

    @GetMapping("/unsecured")
    public String getWithoutLogin(HttpSession session){
        return "Hello UNSECURE";
    }

    @GetMapping("/movie/{id}")
    public Movie getMovieById(@PathVariable(value="id") Long id){
        return tmdService.getMovieById(id);
    }

    @GetMapping("/favourite/{movieId}")
    public Movie addMovieToFavourites(@PathVariable(value="movieId") Long movieId){
        SystemUser systemUser = (SystemUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return tmdService.addMovieToFavourites(systemUser.getId(), movieId);
    }

    @GetMapping("/search")
    public List<Movie> getMoviesByTitle(@RequestParam(value="title") String title){
        return omDbService.getMoviesByTitle(title);
    }

    @PostMapping("/towatch/{movieId}")
    public void addMovieToWatch(@PathVariable(value="movieId") Long movieId){
        SystemUser systemUser = (SystemUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        tmdService.addMovieToWatch(movieId, systemUser.getId());
    }
}
