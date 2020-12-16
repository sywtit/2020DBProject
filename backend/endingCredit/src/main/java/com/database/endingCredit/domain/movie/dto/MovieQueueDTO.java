package com.database.endingCredit.domain.movie.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieQueueDTO {

    private int movieId;
    private String movieName;
    private String movieType;
    private Integer rating;

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
