package com.studeis.http_intro.state.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class MovieApiResponse {

        public String totalResults;
        @JsonProperty("Response")
        public String response;
        @JsonProperty("Search")
        public  List<Movie> search;

}
