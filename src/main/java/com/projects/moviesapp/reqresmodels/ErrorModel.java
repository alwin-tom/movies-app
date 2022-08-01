/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projects.moviesapp.reqresmodels;

/**
 *
 * @author Preetom
 */
public class ErrorModel {

    public Boolean status;
    public String message;

    public ErrorModel(Boolean s, String m) {
        this.status = s;
        this.message = m;
    }

}
