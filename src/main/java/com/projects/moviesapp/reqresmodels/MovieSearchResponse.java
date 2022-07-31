/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projects.moviesapp.reqresmodels;

import com.projects.moviesapp.apimodels.MovieDetailsResponse;
import com.projects.moviesapp.models.MovieDetails;
import lombok.Data;

/**
 *
 * @author Preetom
 */
@Data
public class MovieSearchResponse {

    public Boolean isMoviePresent;
    public MovieDetails movieDetails;
    public MovieDetailsResponse movieDetailsResponse;
}
