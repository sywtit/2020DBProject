package com.database.endingCredit.domain.movie.repository;


import java.util.List;

import com.database.endingCredit.domain.movie.dto.MovieBestSeller;
import com.database.endingCredit.domain.movie.dto.MovieList;
import com.database.endingCredit.domain.movie.dto.MovieQueueDTO;
import com.database.endingCredit.domain.movie.dto.RentalMovieDTO;
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

    @Query(value="SELECT  M.movieId, M.movieName, M.NOF, M.rating FROM movies AS M WHERE M.movieType = :movieType", nativeQuery = true)
	List<RentalMovieDTO> findByType(@Param("movieType") String movieType);

    @Query(value = "SELECT  M.movieId, M.movieName, M.NOF, M.rating FROM movies AS M WHERE M.movieName "+
    "COLLATE UTF8_GENERAL_CI LIKE %:movieName%", nativeQuery = true)
	List<RentalMovieDTO> findByName(@Param("movieName") String movieName);

    @Query(value="SELECT  M.movieId, M.movieName, M.movieType, M.NOF, M.rating FROM movies AS M "+
    "WHERE M.movieId IN (SELECT AC1.movieId FROM actors AS AC1, actors AS AC2 WHERE AC1.movieId = AC2.movieId "+
    "AND (AC1.actorName COLLATE UTF8_GENERAL_CI LIKE %:actorName%))", nativeQuery = true)
    List<RentalMovieDTO> findByActorName(@Param("actorName") String actorName);
    
    @Query(value="SELECT  M.movieId, M.movieName, M.movieType, M.NOF, M.rating FROM movies AS M "+
    "WHERE M.movieId IN (SELECT AC1.movieId FROM actors AS AC1, actors AS AC2 WHERE AC1.movieId = AC2.movieId "+
    "AND (AC1.actorName COLLATE UTF8_GENERAL_CI LIKE %:actorName1% AND AC2.actorName COLLATE UTF8_GENERAL_CI LIKE %:actorName2%))", nativeQuery = true)
	List<RentalMovieDTO> findByActorNameGroup(@Param("actorName1") String actorName1, @Param("actorName2") String actorName2);

    @Query(value = "SELECT  M.movieId, M.movieName, M.movieType, M.rating FROM orders AS od INNER JOIN movies AS M ON od.movieId = M.movieId "+
    "GROUP BY movieId ORDER BY COUNT(*) DESC", nativeQuery = true)
	List<MovieBestSeller> findBestSeller();

    @Query(value = "SELECT M.movieId, M.movieName, M.movieType, M.rating FROM movies AS M", nativeQuery = true)
	List<MovieList> findAllList();


    @Query(value="SELECT COUNT(*) FROM orders AS od WHERE od.returnDate is not null GROUP BY movieId HAVING od.movieId = :movieId", nativeQuery = true)
	int findPeopleNum(@Param("movieId") int movieId);

    @Query(value="SELECT m FROM movies AS m", nativeQuery = true)
	Movies findByIds(int movieId);
    
    
}
