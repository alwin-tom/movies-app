/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projects.moviesapp.controllers;

import com.projects.moviesapp.apimodels.MovieDetailsResponse;
import com.projects.moviesapp.components.MovieDetailsComponent;
import com.projects.moviesapp.models.MovieDetails;
import com.projects.moviesapp.reqresmodels.MovieSearchResponse;
import com.projects.moviesapp.reqresmodels.RatingModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
     * @param movieName
     * @return Movie Search Response
     */
    @GetMapping(value = "/movie", produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieSearchResponse getMovieDetails(@RequestParam("movieName") String movieName) {

        MovieSearchResponse movieSearchResponse = new MovieSearchResponse();
        /**
         * Check DB
         */
        MovieDetails movieDetails = movieDetailsComponent.findByMovieName(movieName);
        if (movieDetails != null) {
            movieSearchResponse.setIsMoviePresent(Boolean.TRUE);

            /**
             * Check API
             */
            MovieDetailsResponse detailsResponse = movieDetailsComponent.invokeMoviesOMDBApi(movieName);
            if (detailsResponse != null && detailsResponse.getResponse().equals("True")) {
                movieDetails.setImdbId(detailsResponse.getImdbID());
                movieDetails.setTheatreGross(Double.parseDouble(detailsResponse.getBoxOffice().replaceAll("\\$", "").replaceAll(",", "")));
                movieDetails.setPoster(detailsResponse.getPoster());
                movieDetails = movieDetailsComponent.update(movieDetails);

                movieSearchResponse.setMovieDetailsResponse(detailsResponse);
            }
            movieSearchResponse.setMovieDetails(movieDetails);

        } else {
            movieSearchResponse.setIsMoviePresent(Boolean.FALSE);
        }
        return movieSearchResponse;
    }

    /**
     * Add rating
     *
     * @param ratingModel
     * @return
     */
    @PostMapping(value = "/rating", produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDetails markRating(@RequestBody RatingModel ratingModel) {
        return movieDetailsComponent.updateByMovieIdandImdbId(ratingModel.getMovieId(), ratingModel.getImdbId(), ratingModel.getRating());
    }

    /**
     * Get all trending movies by Theatre Gross and rating
     * @return top 10 movies
     */
    @GetMapping(value = "/trending", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MovieDetails> getTrendingMovies() {
        return movieDetailsComponent.findTrendingMovies();
    }
}
