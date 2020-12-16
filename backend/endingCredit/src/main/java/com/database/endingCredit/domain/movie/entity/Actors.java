package com.database.endingCredit.domain.movie.entity;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
@Table(name = "actors")
public class Actors {
    
    @EmbeddedId
    private ActorsIndentity actorsIndentity;

    private String actorName;
    private String gender;
    private int age;
    private int rating;


    /**
     * @return ActorsIndentity return the actorsIndentity
     */
    public ActorsIndentity getActorsIndentity() {
        return actorsIndentity;
    }

    /**
     * @param actorsIndentity the actorsIndentity to set
     */
    public void setActorsIndentity(ActorsIndentity actorsIndentity) {
        this.actorsIndentity = actorsIndentity;
    }

    /**
     * @return String return the actorName
     */
    public String getActorName() {
        return actorName;
    }

    /**
     * @param actorName the actorName to set
     */
    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    /**
     * @return String return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return int return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return int return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

}
