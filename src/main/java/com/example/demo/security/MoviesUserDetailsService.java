package com.example.demo.security;

import com.example.demo.repository.SystemUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MoviesUserDetailsService implements UserDetailsService {
    private SystemUserRepository systemUserRepository;

    public MoviesUserDetailsService(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //TODO handle exceptions
        return systemUserRepository.findByEmail(email).orElseThrow();
    }
}
