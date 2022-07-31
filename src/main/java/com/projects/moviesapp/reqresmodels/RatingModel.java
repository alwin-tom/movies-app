/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projects.moviesapp.reqresmodels;

import lombok.Data;

/**
 *
 * @author Preetom
 */
@Data
public class RatingModel {

    public Integer rating;
    public Integer movieId;
    public String imdbId;

}
