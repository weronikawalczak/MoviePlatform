package com.example.demo.model.external;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OMDbMovie {
    public static final String sourceName = "IMDB";

    @JsonAlias("Title")
    private String title;

    @JsonAlias("Year")
    private String year;

    @JsonAlias("Ratings")
    private List<OMDbRating> ratings;

    private String imdbID;

    private String imdbRating;


    public OMDbMovie() {
    }


    @Override
    public String toString() {
        return "OMDbMovie{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", ratings=" + ratings +
                ", imdbID='" + imdbID + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                '}';
    }
}
