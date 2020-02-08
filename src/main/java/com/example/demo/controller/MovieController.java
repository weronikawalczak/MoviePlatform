package com.example.demo.controller;

import com.example.demo.model.Movie;
import com.example.demo.service.implementation.OMDbService;
import com.example.demo.service.implementation.TMDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
