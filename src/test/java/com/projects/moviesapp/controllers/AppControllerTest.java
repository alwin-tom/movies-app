/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projects.moviesapp.controllers;

import com.projects.moviesapp.models.MovieDetails;
import com.projects.moviesapp.reqresmodels.MovieSearchResponse;
import com.projects.moviesapp.reqresmodels.RatingModel;
import java.net.URI;
import java.net.URISyntaxException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Preetom
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AppControllerTest {

    @LocalServerPort
    int randomServerPort;

    @Test
    public void getMovieDetailsFailedSenario() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + randomServerPort + "/v1/movie?movieName=DUMMY";
        URI uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.set("client-token", "sample-client-token");

        ResponseEntity<MovieSearchResponse> result = new TestRestTemplate().exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), MovieSearchResponse.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody() != null);
        Assert.assertEquals(true, !result.getBody().getIsMoviePresent());

    }

    @Test
    public void getMovieDetailsSuccessScenario() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + randomServerPort + "/v1/movie?movieName=Inception";
        URI uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.set("client-token", "sample-client-token");

        ResponseEntity<MovieSearchResponse> result = new TestRestTemplate().exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), MovieSearchResponse.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody() != null);
        Assert.assertEquals(true, result.getBody().getIsMoviePresent());

    }

    @Test
    public void getMovieDetailsBadRequest() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + randomServerPort + "/v1/movie";
        URI uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.set("client-token", "sample-client-token");
        ResponseEntity<MovieSearchResponse> result = new TestRestTemplate().exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), MovieSearchResponse.class);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());

    }

    @Test
    public void getMovieDetailsUnauthorisedRequest() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + randomServerPort + "/v1/movie";
        URI uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.set("client-token-invalid", "sample-client-token");
        ResponseEntity<MovieSearchResponse> result = new TestRestTemplate().exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), MovieSearchResponse.class);
        System.out.println(result.getStatusCode());
        Assert.assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());

    }

    @Test
    public void getTrending() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + randomServerPort + "/v1/trending";
        URI uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.set("client-token", "sample-client-token");

        ResponseEntity<Object[]> result = new TestRestTemplate().exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), Object[].class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody() != null);
        Assert.assertNotNull(result.getBody());

    }

    @Test
    public void getMarkRating() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + randomServerPort + "/v1/rating";
        URI uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.set("client-token", "sample-client-token");

        RatingModel ratingModel = RatingModel.builder()
                .imdbId("tt1375666")
                .movieId(3)
                .rating(4)
                .build();
        HttpEntity<RatingModel> entity = new HttpEntity<>(ratingModel, headers);

        ResponseEntity<MovieDetails> result = new TestRestTemplate().exchange(uri, HttpMethod.POST, entity, MovieDetails.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody() != null);
        Assert.assertNotNull(result.getBody());

    }

}
