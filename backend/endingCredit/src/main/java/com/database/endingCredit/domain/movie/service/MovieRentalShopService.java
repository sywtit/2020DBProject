package com.database.endingCredit.domain.movie.service;

import java.util.ArrayList;
import java.util.List;

import com.database.endingCredit.domain.movie.dto.MovieActorNameDTO;
import com.database.endingCredit.domain.movie.dto.MovieBestSeller;
import com.database.endingCredit.domain.movie.dto.MovieBlobDTO;
import com.database.endingCredit.domain.movie.dto.MovieList;
import com.database.endingCredit.domain.movie.dto.MovieNameDTO;
import com.database.endingCredit.domain.movie.dto.MovieRatingDTO;
import com.database.endingCredit.domain.movie.dto.MovieTypeDTO;
import com.database.endingCredit.domain.movie.dto.RentalMovieDTO;
import com.database.endingCredit.domain.movie.entity.Movies;
import com.database.endingCredit.domain.movie.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieRentalShopService {

    @Autowired
    private MovieRepository movieRepository;

	public List<RentalMovieDTO> getInfoListByType(MovieTypeDTO movieTypeDTO) {

        List<RentalMovieDTO> rentalMovieDTO = movieRepository.findByType(movieTypeDTO.getMovieType());
		return rentalMovieDTO;
	}

	public List<RentalMovieDTO> getInfoListByMovieName(MovieNameDTO movieNameDTO) {
		List<RentalMovieDTO> rentalMovieDTO = movieRepository.findByName(movieNameDTO.getMovieName());
		return rentalMovieDTO;
	}

	public List<RentalMovieDTO> getInfoListByActorName(List<MovieActorNameDTO> movieActorNameDTOs) {
        int size = movieActorNameDTOs.size();
        List<RentalMovieDTO> rentalMovieDTO = new ArrayList<RentalMovieDTO>();
        if(size ==1)
        {
            rentalMovieDTO = movieRepository.findByActorName(movieActorNameDTOs.get(0).getActorName());
        }
        else if(size ==2)
        {
            rentalMovieDTO = movieRepository.findByActorNameGroup(movieActorNameDTOs.get(0).getActorName(), movieActorNameDTOs.get(1).getActorName());
        }
        return rentalMovieDTO;

	}

	public MovieBlobDTO getMovieBlobContent() {
        List<MovieBestSeller> movieBestSellers = movieRepository.findBestSeller();
        List<MovieList> movieLists = movieRepository.findAllList();

        MovieBlobDTO blobDTO = new MovieBlobDTO();
        blobDTO.setBestSellerList(movieBestSellers);
        blobDTO.setWholeMovieList(movieLists);

        return blobDTO;
	}

	public void giveMovieRates(MovieRatingDTO movieRatingDTO) {

        long peoplenum = 0; int rating = 0;
        peoplenum = movieRepository.findPeopleNum(movieRatingDTO.getMovieId());
        Movies movie = movieRepository.findByIds(movieRatingDTO.getMovieId());
        rating = movie.getRating();

        int newRate = (((int)peoplenum*rating)+movieRatingDTO.getRating())/((int)peoplenum+1);
        movie.setRating(newRate);
        movieRepository.save(movie);
        
        
	}
    
}
