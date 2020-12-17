package com.database.endingCredit.domain.movie.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieTypeDTO {
    
    private String movieType;
    

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

}
