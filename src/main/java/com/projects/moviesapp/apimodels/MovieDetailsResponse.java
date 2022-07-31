/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projects.moviesapp.apimodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Preetom
 */
@Data
public class MovieDetailsResponse {

    @JsonProperty(value = "Title", required = false)
    public String title;

    @JsonProperty(value = "Year", required = false)
    public String year;

    @JsonProperty(value = "Rated", required = false)
    public String rated;

    @JsonProperty(value = "Released", required = false)
    public String released;

    @JsonProperty(value = "Runtime", required = false)
    public String runtime;

    @JsonProperty(value = "Genre", required = false)
    public String genre;

    @JsonProperty(value = "Director", required = false)
    public String director;

    @JsonProperty(value = "Writer", required = false)
    public String writer;

    @JsonProperty(value = "Actors", required = false)
    public String actors;

    @JsonProperty(value = "Plot", required = false)
    public String plot;

    @JsonProperty(value = "Language", required = false)
    public String language;

    @JsonProperty(value = "Country", required = false)
    public String country;

    @JsonProperty(value = "Awards", required = false)
    public String awards;

    @JsonProperty(value = "Poster", required = false)
    public String poster;

    @JsonProperty(value = "Metascore", required = false)
    public String metascore;

    @JsonProperty(value = "imdbRating", required = false)
    public String imdbRating;

    @JsonProperty(value = "imdbVotes", required = false)
    public String imdbVotes;

    @JsonProperty(value = "imdbID", required = false)
    public String imdbID;

    @JsonProperty(value = "Type", required = false)
    public String type;

    @JsonProperty(value = "DVD", required = false)
    public String dvd;

    @JsonProperty(value = "BoxOffice", required = false)
    public String boxOffice;

    @JsonProperty(value = "Production", required = false)
    public String production;

    @JsonProperty(value = "Website", required = false)
    public String website;

    @JsonProperty(value = "Response", required = true)
    public String response;

    @JsonProperty(value = "Ratings", required = false)
    List<Ratings> ratings;

}
