package com.database.endingCredit.domain.movie.entity;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ActorsIndentity implements Serializable {
    
    private int actorId;
    private int movieId;

    /**
     * @return int return the actorId
     */
    public int getActorId() {
        return actorId;
    }

    /**
     * @param actorId the actorId to set
     */
    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

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

}
