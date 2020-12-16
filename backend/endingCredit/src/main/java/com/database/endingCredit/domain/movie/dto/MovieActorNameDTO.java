package com.database.endingCredit.domain.movie.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieActorNameDTO {
    private String actorName;


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

}
