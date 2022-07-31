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
    MovieDetailsService movieDetailsService;

    @Autowired
    RestTemplate restTemplate;

    public MovieDetails findByMovieName(String movieName) {
        return movieDetailsService.findByMovieName(movieName.toUpperCase());
    }

    public MovieDetailsResponse invokeMoviesOMDBApi(String movieName) {
        String uri = "http://www.omdbapi.com/?t=" + movieName + "&apikey=ccff19c0";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                entity,
                String.class
        );

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

    public MovieDetails update(MovieDetails movieDetails) {
        return movieDetailsService.update(movieDetails);
    }

    public MovieDetails updateByMovieIdandImdbId(Integer movieId, String imdbId, Integer rating) {
        return movieDetailsService.updateByMovieIdandImdbId(movieId, imdbId, rating);
    }

    public List<MovieDetails> findTrendingMovies() {
        return movieDetailsService.findTrendingMovies();
    }

}
