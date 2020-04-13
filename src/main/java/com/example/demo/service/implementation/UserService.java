package com.example.demo.service.implementation;

import com.example.demo.entity.Movie;
import com.example.demo.entity.SystemUser;
import com.example.demo.repository.SystemMovieRepository;
import com.example.demo.repository.SystemUserRepository;
import com.example.demo.util.Role;
import com.example.demo.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private SystemUserRepository systemUserRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(SystemUserRepository systemUserRepository, PasswordEncoder passwordEncoder) {
        this.systemUserRepository = systemUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Movie> favouritesMovies(String userId){
        return systemUserRepository.findById(Long.parseLong(userId)).get().getFavourites();
    }

    public SystemUser register(String email, String password){
        SystemUser systemUser = new SystemUser();
        //TODO repair it
//        SystemUser.builder().email(email).password(passwordEncoder.encode(password)).role(String.valueOf(Role.ROLE_USER)).state(State.INACTIVE).build();
        systemUser.setEmail(email);
        systemUser.setPassword(passwordEncoder.encode(password));
        systemUser.setRole(String.valueOf(Role.ROLE_USER));
        systemUser.setState(State.INACTIVE);
        systemUserRepository.save(systemUser);
        //TODO send email
        return systemUser;
    }
}
