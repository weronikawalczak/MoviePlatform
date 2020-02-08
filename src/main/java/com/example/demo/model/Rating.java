package com.example.demo.model;

import com.example.demo.model.external.OMDbRating;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Rating {
    private String source;
    private String value;

    public static Rating of(OMDbRating omDbRating){
        return new Rating(omDbRating.getSource(), omDbRating.getValue());
    }
}
