/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projects.moviesapp.errorhandlers;

import com.projects.moviesapp.reqresmodels.ErrorModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Preetom
 */
@ControllerAdvice
public class MoviesAppErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = {UnAuthorisedError.class})
    protected ResponseEntity<Object> handleConflict(
            Exception ex, WebRequest request) {
        return new ResponseEntity<>(
                new ErrorModel(Boolean.FALSE, ex.getMessage()), new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value
            = {Exception.class})
    protected ResponseEntity<Object> handleAllErrors(
            Exception ex, WebRequest request) {
        return new ResponseEntity<>(
                new ErrorModel(Boolean.FALSE, ex.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
