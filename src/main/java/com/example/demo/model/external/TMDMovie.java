package com.example.demo.model.external;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TMDMovie {
    public static final String sourceName = "The Movie Database";


    private String title;

    @JsonAlias("release_date")
    private String year;

    @JsonAlias("vote_average")
    private String voteAverage;

    private String id;

    public TMDMovie() {
    }


    @Override
    public String toString() {
        return "TMDMovie{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", voteAverage='" + voteAverage + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
