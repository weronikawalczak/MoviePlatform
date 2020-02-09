package com.example.demo.model.external;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OMDbMovieSearch {
    private int page;

    @JsonAlias("results")
    private List<OMDbMovie> omDbMovies;
}
