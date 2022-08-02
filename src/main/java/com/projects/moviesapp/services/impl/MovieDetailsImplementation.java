/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projects.moviesapp.services.impl;

import com.projects.moviesapp.dao.MovieDetailsDAO;
import com.projects.moviesapp.models.MovieDetails;
import com.projects.moviesapp.services.MovieDetailsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Preetom
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class MovieDetailsImplementation implements MovieDetailsService {

    @Autowired
    MovieDetailsDAO movieDetailsDAO;

    @Override
    public MovieDetails findByMovieName(String movieName) {
        return movieDetailsDAO.findByMovieName(movieName);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public MovieDetails update(MovieDetails movieDetails) {
        return movieDetailsDAO.save(movieDetails);
    }

    /**
     * Find movie by movieId and IMDB ID and update the rating
     *
     * @param movieId
     * @param imdbId
     * @param rating
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public MovieDetails updateByMovieIdAndImdbId(Integer movieId, String imdbId, Integer rating) {
        MovieDetails movieDetails = movieDetailsDAO.findByMovieIdAndImdbId(movieId, imdbId);
        Float totalRating = movieDetails.getAverageRating() * movieDetails.getTotalRatings();
        movieDetails = movieDetails.toBuilder()
                .totalRatings(movieDetails.getTotalRatings() + 1)
                .build();
        movieDetails = movieDetails.toBuilder()
                .averageRating((totalRating + rating) / movieDetails.getTotalRatings())
                .build();
        return movieDetailsDAO.save(movieDetails);
    }

    /**
     * Sort the 1st 10 records sorted by average rating and theatre gross
     *
     * @return
     */
    @Override
    public List<MovieDetails> findTrendingMovies() {
        List<MovieDetails> page = movieDetailsDAO.findTrendingMovies(
                PageRequest.of(0, 10, Sort.by(
                        Sort.Order.desc("averageRating"),
                        Sort.Order.desc("theatreGross")
                )));
        return page;
    }

}
