/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projects.moviesapp.components;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.moviesapp.apimodels.MovieDetailsResponse;
import com.projects.moviesapp.models.MovieDetails;
import com.projects.moviesapp.services.MovieDetailsService;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Preetom
 */
@Component
public class MovieDetailsComponent {

    @Autowired
    private final Environment environment;

    @Autowired
    MovieDetailsService movieDetailsService;

    @Autowired
    RestTemplate restTemplate;

    MovieDetailsComponent(Environment e) {
        this.environment = e;
    }

    /**
     *
     * @param movieName
     * @return movie details from DB
     */
    public MovieDetails findByMovieName(String movieName) {
        return movieDetailsService.findByMovieName(movieName.toUpperCase());
    }

    /**
     *
     * @param movieName
     * @return movie search details
     */
    public MovieDetailsResponse invokeMoviesOMDBApi(String movieName) {
        /**
         * Invoke the OMDB API for fetching movie details
         */
        String uri = environment.getRequiredProperty("omdb.api") + "t=" + movieName + "&apikey=" + environment.getRequiredProperty("omdb.apikey");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                entity,
                String.class
        );

        /**
         * Check if the API call is successfull
         */
        if (response.getStatusCode().is2xxSuccessful()) {
            try {
                MovieDetailsResponse detailsResponse = new ObjectMapper().readValue((String) response.getBody(), MovieDetailsResponse.class);
                return detailsResponse;
            } catch (JsonProcessingException ex) {
                Logger.getLogger(MovieDetailsComponent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        MovieDetailsResponse detailsResponse = new MovieDetailsResponse();
        detailsResponse.setResponse("False");
        return detailsResponse;

    }

    /**
     * @param movieDetails
     * @return
     */
    public MovieDetails update(MovieDetails movieDetails) {
        return movieDetailsService.update(movieDetails);
    }

    /**
     *
     * @param movieId
     * @param imdbId
     * @param rating
     * @return
     */
    public MovieDetails updateByMovieIdandImdbId(Integer movieId, String imdbId, Integer rating) {
        return movieDetailsService.updateByMovieIdandImdbId(movieId, imdbId, rating);
    }

    /**
     * @return
     */
    public List<MovieDetails> findTrendingMovies() {
        return movieDetailsService.findTrendingMovies();
    }

}
