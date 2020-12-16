package com.database.endingCredit.domain.movie.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movies {
    
    @Id
    private int movieId;

    private String movieName;
    private String movieType;
    private Integer NOF;
    private Integer rating;

    /**
     * @return int return the movieId
     */
    public int getMovieId() {
        return movieId;
    }

    /**
     * @param movieId the movieId to set
     */
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    /**
     * @return String return the movieName
     */
    public String getMovieName() {
        return movieName;
    }

    /**
     * @param movieName the movieName to set
     */
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    /**
     * @return String return the movieType
     */
    public String getMovieType() {
        return movieType;
    }

    /**
     * @param movieType the movieType to set
     */
    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    /**
     * @return Integer return the NOF
     */
    public Integer getNOF() {
        return NOF;
    }

    /**
     * @param NOF the NOF to set
     */
    public void setNOF(Integer NOF) {
        this.NOF = NOF;
    }

    /**
     * @return Integer return the rating
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }

}
