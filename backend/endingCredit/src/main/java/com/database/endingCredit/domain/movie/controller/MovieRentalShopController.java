package com.database.endingCredit.domain.movie.controller;

import java.util.List;

import com.database.endingCredit.domain.movie.dto.MovieActorNameDTO;
import com.database.endingCredit.domain.movie.dto.MovieBlobDTO;
import com.database.endingCredit.domain.movie.dto.MovieNameDTO;
import com.database.endingCredit.domain.movie.dto.MovieRatingDTO;
import com.database.endingCredit.domain.movie.dto.MovieTypeDTO;
import com.database.endingCredit.domain.movie.dto.RentalMovieDTO;
import com.database.endingCredit.domain.movie.service.MovieRentalShopService;
import com.database.endingCredit.domain.user.dto.UserIdDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rentalShop")
public class MovieRentalShopController {
    
    @Autowired
    private MovieRentalShopService service;

    @CrossOrigin(origins = "*")
    @PostMapping("/byType")
    @ResponseStatus(value = HttpStatus.OK)
    public List<RentalMovieDTO> getMovieByType(@RequestBody MovieTypeDTO movieTypeDTO) {
        return service.getInfoListByType(movieTypeDTO);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/byMovieName")
    @ResponseStatus(value = HttpStatus.OK)
    public List<RentalMovieDTO> getMovieByMovieName(@RequestBody MovieNameDTO movieNameDTO) {
        return service.getInfoListByMovieName(movieNameDTO);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/byActors")
    @ResponseStatus(value = HttpStatus.OK)
    public List<RentalMovieDTO> getMovieByActorName(@RequestBody List<MovieActorNameDTO> movieActorNameDTOs) {
        return service.getInfoListByActorName(movieActorNameDTOs);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/blob")
    @ResponseStatus(value = HttpStatus.OK)
    public MovieBlobDTO getMovieBlob(@RequestBody UserIdDTO userIdDTO) {
        return service.getMovieBlobContent();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/rate")
    @ResponseStatus(value = HttpStatus.OK)
    public void rate(@RequestBody MovieRatingDTO movieRatingDTO) {
        service.giveMovieRates(movieRatingDTO);
    }


}
