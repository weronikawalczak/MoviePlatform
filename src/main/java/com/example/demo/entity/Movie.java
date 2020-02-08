package com.example.demo.entity;

import com.example.demo.model.Rating;
import com.example.demo.model.external.OMDbMovie;
import com.example.demo.model.external.TMDMovie;
import com.example.demo.util.Converter;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String year;

    @Transient
    private List<Rating> ratings;

    @Column(unique = true)
    private String externalID;

    public static Movie of(OMDbMovie omDbMovie){
        return Converter.convert(omDbMovie);
    }

    public static Movie of(TMDMovie theMovieMovie){
        return Converter.convert(theMovieMovie);
    }
}
