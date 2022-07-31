/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projects.moviesapp.apimodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *
 * @author Preetom
 */
@Data
public class Ratings {

    @JsonProperty(value = "Source", required = false)
    String source;

    @JsonProperty(value = "Value", required = false)
    String value;
}
