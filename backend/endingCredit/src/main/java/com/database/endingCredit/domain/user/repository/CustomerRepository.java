package com.database.endingCredit.domain.user.repository;


import com.database.endingCredit.domain.user.entity.Customers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//entity, primary key
@Repository
public interface CustomerRepository extends JpaRepository<Customers, String>{

    @Query(value="SELECT * FROM customers c ORDER BY DESC LIMIT 1", nativeQuery = true)
	Customers findRecentIdNumber();

	Customers findByEmail(String email);
    
    // @Query(value="SELECT * FROM user u WHERE u.id= :id", nativeQuery = true)
    // User findByIdNumber(@Param("id") Integer Id);
    
}
