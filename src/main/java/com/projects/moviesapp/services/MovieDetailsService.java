/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projects.moviesapp.services;

import com.projects.moviesapp.models.MovieDetails;
import java.util.List;

/**
 *
 * @author Preetom
 */
public interface MovieDetailsService {

    public MovieDetails findByMovieName(String movieName);

    public MovieDetails update(MovieDetails movieDetails);

    public MovieDetails updateByMovieIdAndImdbId(Integer movieId, String imdbId, Integer rating);

    public List<MovieDetails> findTrendingMovies();
}
