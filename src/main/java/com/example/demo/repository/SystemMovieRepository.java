package com.example.demo.repository;

import com.example.demo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SystemMovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findById(Long id);
}
