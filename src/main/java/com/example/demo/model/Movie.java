package com.example.demo.model;

import com.example.demo.model.external.OMDbMovie;
import com.example.demo.model.external.TMDMovie;
import com.example.demo.util.Converter;
import lombok.Data;

import java.util.List;

@Data
public class Movie {
    private String title;
    private String year;
    private List<Rating> ratings;

    public static Movie of(OMDbMovie omDbMovie){
        return Converter.convert(omDbMovie);
    }

    public static Movie of(TMDMovie theMovieMovie){
        return Converter.convert(theMovieMovie);
    }

}
