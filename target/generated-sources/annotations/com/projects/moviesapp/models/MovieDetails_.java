package com.projects.moviesapp.models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-31T17:44:22")
@StaticMetamodel(MovieDetails.class)
public class MovieDetails_ { 

    public static volatile SingularAttribute<MovieDetails, Boolean> isDeleted;
    public static volatile SingularAttribute<MovieDetails, Date> created;
    public static volatile SingularAttribute<MovieDetails, String> imdbId;
    public static volatile SingularAttribute<MovieDetails, Float> averageRating;
    public static volatile SingularAttribute<MovieDetails, Integer> totalRatings;
    public static volatile SingularAttribute<MovieDetails, Double> theatreGross;
    public static volatile SingularAttribute<MovieDetails, Integer> movieId;
    public static volatile SingularAttribute<MovieDetails, Boolean> hasWonOscar;
    public static volatile SingularAttribute<MovieDetails, String> movieName;
    public static volatile SingularAttribute<MovieDetails, String> poster;

}