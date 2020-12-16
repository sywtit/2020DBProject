package com.database.endingCredit.domain.movie.repository;


import java.util.List;

import com.database.endingCredit.domain.movie.dto.MovieQueueDTO;
import com.database.endingCredit.domain.movie.dto.UserMovieDTO;
import com.database.endingCredit.domain.movie.entity.Movies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//entity, primary key
@Repository
public interface MovieRepository extends JpaRepository<Movies, Integer>{

    @Query(value=" SELECT  M.movieId, M.movieName, M.movieType, M.rating"+
    " FROM movies AS M, accounts AS acnt"+
    " WHERE acnt.customerId = :customerId"+
    " AND M.movieId"+
    " IN"+
    " ( SELECT od1.movieId FROM orders AS od1 WHERE acnt.movieId = od1.movieId AND acnt.accountId = od1.accountId"+
    " AND EXISTS ( SELECT COUNT(*) AS cnt FROM orders AS od"+ 
    " WHERE od.returnDate is null AND od.rentalDate < od1.rentalDate GROUP BY movieId HAVING cnt <= M.NOF"+
    "))", nativeQuery = true)
	List<UserMovieDTO> getCurrentlyHeldList(@Param("customerId") String customerId);

    @Query(value="SELECT  M.movieId, M.movieName, M.movieType, M.rating "+
    "FROM movies AS M, accounts AS acnt, orders AS od1 "+
    "WHERE acnt.customerId = :customerId "+
    "AND M.movieId "+
    "IN ( SELECT od1.movieId FROM orders AS od "+
    "WHERE acnt.movieId = od.movieId AND acnt.accountId = od.accountId AND od.returnDate is null AND od1.rentalDate=od.rentalDate "+
    ") ORDER BY od1.rentalDate", nativeQuery = true)
	List<MovieQueueDTO> getMovieQueue(@Param("customerId") String customerId);
    
}
