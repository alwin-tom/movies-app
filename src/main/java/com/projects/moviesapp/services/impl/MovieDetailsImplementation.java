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
import org.springframework.data.domain.Page;
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public MovieDetails updateByMovieIdandImdbId(Integer movieId, String imdbId, Integer rating) {
        MovieDetails movieDetails = movieDetailsDAO.findByMovieIdandImdbId(movieId, imdbId);
        Float totalRating = movieDetails.getAverageRating() * movieDetails.getTotalRatings();
        movieDetails.setTotalRatings(movieDetails.getTotalRatings() + 1);
        Float newRating = (totalRating + rating) / movieDetails.getTotalRatings();
        movieDetails.setAverageRating(newRating);

        return movieDetailsDAO.save(movieDetails);
    }

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
