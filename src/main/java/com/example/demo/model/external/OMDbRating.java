package com.example.demo.model.external;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OMDbRating {
    @JsonAlias("Source")
    private String source;

    @JsonAlias("Value")
    private String value;


    public OMDbRating() {
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "OMDbRating{" +
                "source='" + source + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
