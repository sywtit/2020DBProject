package com.database.endingCredit.domain.user.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class AccountsIdentity implements Serializable{
    
    private int AccountId;
    private int MovieId;


    /**
     * @return int return the AccountId
     */
    public int getAccountId() {
        return AccountId;
    }

    /**
     * @param AccountId the AccountId to set
     */
    public void setAccountId(int AccountId) {
        this.AccountId = AccountId;
    }

    /**
     * @return int return the MovieId
     */
    public int getMovieId() {
        return MovieId;
    }

    /**
     * @param MovieId the MovieId to set
     */
    public void setMovieId(int MovieId) {
        this.MovieId = MovieId;
    }

}
