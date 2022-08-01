/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projects.moviesapp.errorhandlers;

/**
 *
 * @author Preetom
 */
public class UnAuthorisedError extends Exception {

    public UnAuthorisedError(String exceptionDetails) {
        super(exceptionDetails);
    }

}
