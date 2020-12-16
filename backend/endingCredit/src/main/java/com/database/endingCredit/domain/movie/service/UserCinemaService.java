package com.database.endingCredit.domain.movie.service;

import java.util.List;

import com.database.endingCredit.domain.movie.dto.MovieQueueDTO;
import com.database.endingCredit.domain.movie.dto.UserCinemaDTO;
import com.database.endingCredit.domain.movie.dto.UserMovieDTO;
import com.database.endingCredit.domain.movie.repository.MovieRepository;
import com.database.endingCredit.domain.user.dto.UserIdDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCinemaService {

    @Autowired
    private MovieRepository movieRepository;

	public UserCinemaDTO getInfoList(UserIdDTO userIdDTO) {

        String customerId = userIdDTO.getCustomerId();

        //current held movie
        List<UserMovieDTO> userMovieDTOs =  movieRepository.getCurrentlyHeldList(customerId);

        //movie queue
        List<MovieQueueDTO> movieQueueDTOs = movieRepository.getMovieQueue(customerId);

        UserCinemaDTO userCinemaDTO = new UserCinemaDTO();
        userCinemaDTO.setMovieQueue(movieQueueDTOs);
        userCinemaDTO.setUserMovieList(userMovieDTOs);

		return userCinemaDTO;
	}
    
}
