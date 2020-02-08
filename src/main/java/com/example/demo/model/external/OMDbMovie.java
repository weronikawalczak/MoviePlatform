package com.example.demo.model.external;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OMDbMovie {
    public static final String sourceName = "IMDB";

    @JsonAlias("Title")
    private String title;

    @JsonAlias("Year")
    private String year;

    @JsonAlias("Ratings")
    private List<OMDbRating> ratings;

    private String imdbRating;




    public OMDbMovie() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<OMDbRating> getRatings() {
        return ratings;
    }

    public void setRatings(List<OMDbRating> ratings) {
        this.ratings = ratings;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    @Override
    public String toString() {
        return "OMDbMovie{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", ratings=" + ratings +
                ", imdbRating='" + imdbRating + '\'' +
                '}';
    }
}
