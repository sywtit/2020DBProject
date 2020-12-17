package com.database.endingCredit.domain.movie.dto;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserCinemaDTO {
    
    private List<MovieQueueDTO> movieQueue;
    private List<UserMovieDTO> userMovieList;

    /**
     * @return List<MovieQueueDTO> return the movieQueue
     */
    public List<MovieQueueDTO> getMovieQueue() {
        return movieQueue;
    }

    /**
     * @param movieQueue the movieQueue to set
     */
    public void setMovieQueue(List<MovieQueueDTO> movieQueue) {
        this.movieQueue = movieQueue;
    }

    /**
     * @return List<UserMovieDTO> return the userMovieList
     */
    public List<UserMovieDTO> getUserMovieList() {
        return userMovieList;
    }

    /**
     * @param userMovieList the userMovieList to set
     */
    public void setUserMovieList(List<UserMovieDTO> userMovieList) {
        this.userMovieList = userMovieList;
    }

}
