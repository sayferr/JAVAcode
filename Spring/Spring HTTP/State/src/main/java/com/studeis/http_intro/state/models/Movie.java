package com.studeis.http_intro.state.models;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Movie {
    @JsonProperty("Title")
    public String title;
    @JsonProperty("Year")
    public String year;
    public String imdbID;
    @JsonProperty("Type")
    public String type;
    @JsonProperty("Poster")
    public String poster;
}
