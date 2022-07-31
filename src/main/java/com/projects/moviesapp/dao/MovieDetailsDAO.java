/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projects.moviesapp.dao;

import com.projects.moviesapp.models.MovieDetails;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Preetom
 */
@Repository
public interface MovieDetailsDAO extends JpaRepository<MovieDetails, Integer> {

    @Query(value = "SELECT e FROM MovieDetails e where upper(e.movieName) = ?1 and e.isDeleted = false")
    public MovieDetails findByMovieName(String movieName);

    @Query(value = "SELECT e FROM MovieDetails e where e.movieId = ?1 and e.imdbId = ?2 and e.isDeleted = false")
    public MovieDetails findByMovieIdandImdbId(Integer movieId, String imdbId);
    
    @Query(value = "SELECT e FROM MovieDetails e where e.averageRating > 0 and e.isDeleted = false")
    public List<MovieDetails> findTrendingMovies(Pageable pageable);

}