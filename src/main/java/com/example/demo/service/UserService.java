package com.example.demo.service;

import com.example.demo.entity.Movie;
import com.example.demo.entity.SystemUser;
import com.example.demo.repository.SystemMovieRepository;
import com.example.demo.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    SystemUserRepository systemUserRepository;

    public List<Movie> favouritesMovies(String userId){
        return systemUserRepository.findById(Long.parseLong(userId)).get().getMovies();
    }
}
