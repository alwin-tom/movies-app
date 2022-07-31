/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projects.moviesapp.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Preetom
 */
@Entity
@Table(name = "movie_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MovieDetails.findAll", query = "SELECT m FROM MovieDetails m"),
    @NamedQuery(name = "MovieDetails.findByMovieId", query = "SELECT m FROM MovieDetails m WHERE m.movieId = :movieId"),
    @NamedQuery(name = "MovieDetails.findByMovieName", query = "SELECT m FROM MovieDetails m WHERE m.movieName = :movieName"),
    @NamedQuery(name = "MovieDetails.findByHasWonOscar", query = "SELECT m FROM MovieDetails m WHERE m.hasWonOscar = :hasWonOscar"),
    @NamedQuery(name = "MovieDetails.findByTheatreGross", query = "SELECT m FROM MovieDetails m WHERE m.theatreGross = :theatreGross"),
    @NamedQuery(name = "MovieDetails.findByAverageRating", query = "SELECT m FROM MovieDetails m WHERE m.averageRating = :averageRating"),
    @NamedQuery(name = "MovieDetails.findByCreated", query = "SELECT m FROM MovieDetails m WHERE m.created = :created"),
    @NamedQuery(name = "MovieDetails.findByIsDeleted", query = "SELECT m FROM MovieDetails m WHERE m.isDeleted = :isDeleted"),
    @NamedQuery(name = "MovieDetails.findByImdbId", query = "SELECT m FROM MovieDetails m WHERE m.imdbId = :imdbId"),
    @NamedQuery(name = "MovieDetails.findByTotalRatings", query = "SELECT m FROM MovieDetails m WHERE m.totalRatings = :totalRatings"),
    @NamedQuery(name = "MovieDetails.findByPoster", query = "SELECT m FROM MovieDetails m WHERE m.poster = :poster")})
public class MovieDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "movie_id")
    private Integer movieId;
    @Size(max = 500)
    @Column(name = "movie_name")
    private String movieName;
    @Column(name = "has_won_oscar")
    private Boolean hasWonOscar;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "theatre_gross")
    private Double theatreGross;
    @Column(name = "average_rating")
    private Float averageRating;
    @Column(name = "created")
    @Temporal(TemporalType.DATE)
    private Date created;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "imdb_id")
    private String imdbId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_ratings")
    private int totalRatings;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "poster")
    private String poster;

    public MovieDetails() {
    }

    public MovieDetails(Integer movieId) {
        this.movieId = movieId;
    }

    public MovieDetails(Integer movieId, String imdbId, int totalRatings, String poster) {
        this.movieId = movieId;
        this.imdbId = imdbId;
        this.totalRatings = totalRatings;
        this.poster = poster;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Boolean getHasWonOscar() {
        return hasWonOscar;
    }

    public void setHasWonOscar(Boolean hasWonOscar) {
        this.hasWonOscar = hasWonOscar;
    }

    public Double getTheatreGross() {
        return theatreGross;
    }

    public void setTheatreGross(Double theatreGross) {
        this.theatreGross = theatreGross;
    }

    public Float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Float averageRating) {
        this.averageRating = averageRating;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(int totalRatings) {
        this.totalRatings = totalRatings;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieId != null ? movieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovieDetails)) {
            return false;
        }
        MovieDetails other = (MovieDetails) object;
        if ((this.movieId == null && other.movieId != null) || (this.movieId != null && !this.movieId.equals(other.movieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projects.moviesapp.models.MovieDetails[ movieId=" + movieId + " ]";
    }
    
}
