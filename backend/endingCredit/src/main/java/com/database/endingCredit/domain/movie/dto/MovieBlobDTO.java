package com.database.endingCredit.domain.movie.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieBlobDTO {
    private List<MovieList> wholeMovieList;
    private List<MovieBestSeller> bestSellerList;


    /**
     * @return List<MovieList> return the wholeMovieList
     */
    public List<MovieList> getWholeMovieList() {
        return wholeMovieList;
    }

    /**
     * @param wholeMovieList the wholeMovieList to set
     */
    public void setWholeMovieList(List<MovieList> wholeMovieList) {
        this.wholeMovieList = wholeMovieList;
    }

    /**
     * @return List<MovieBestSeller> return the bestSellerList
     */
    public List<MovieBestSeller> getBestSellerList() {
        return bestSellerList;
    }

    /**
     * @param bestSellerList the bestSellerList to set
     */
    public void setBestSellerList(List<MovieBestSeller> bestSellerList) {
        this.bestSellerList = bestSellerList;
    }

}
