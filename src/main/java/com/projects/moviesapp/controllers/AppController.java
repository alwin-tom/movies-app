/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projects.moviesapp.controllers;

import com.projects.moviesapp.components.MovieDetailsComponent;
import com.projects.moviesapp.models.MovieDetails;
import com.projects.moviesapp.reqresmodels.MovieSearchResponse;
import com.projects.moviesapp.reqresmodels.RatingModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Preetom
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1")
public class AppController {

    @Autowired
    MovieDetailsComponent movieDetailsComponent;

    /**
     * use: For searching movies by comparing DB and OMDB API
     *
     * @param clientToken
     * @param movieName
     * @return Movie Search Response
     */
    @GetMapping(value = "/movie")
    public MovieSearchResponse getMovieDetails(@RequestHeader("client-token") String clientToken,
            @RequestParam("movieName") String movieName) {
        return movieDetailsComponent.findByMovieName(movieName);
    }

    /**
     * Add rating
     *
     * @param clientToken
     * @param ratingModel
     * @return
     */
    @PostMapping(value = "/rating")
    public MovieDetails markRating(@RequestHeader("client-token") String clientToken,
            @RequestBody RatingModel ratingModel) {
        return movieDetailsComponent.updateByMovieIdAndImdbId(ratingModel.getMovieId(), ratingModel.getImdbId(), ratingModel.getRating());
    }

    /**
     * Get all trending movies by Theatre Gross and rating
     *
     * @param clientToken
     * @return top 10 movies
     */
    @GetMapping(value = "/trending")
    public List<MovieDetails> getTrendingMovies(@RequestHeader("client-token") String clientToken) {
        return movieDetailsComponent.findTrendingMovies();
    }
}
