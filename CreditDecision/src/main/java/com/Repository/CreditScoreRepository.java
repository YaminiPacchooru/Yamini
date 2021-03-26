package com.Repository;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Model.CreditScore;

public interface CreditScoreRepository extends CrudRepository<CreditScore,Long>{

	@Query("select creditScore from CreditScore a where a.ssnNumber = :ssnNumber")
	long findBySsnNumberReturnStream(int ssnNumber);
	
	 @Query("select date from CreditScore a where a.ssnNumber = :ssnNumber")
	 LocalDate findDate(int ssnNumber);
	 
		
		  @Query("select  DATEDIFF(localDate,date) from CreditScore a where a.ssnNumber =:ssnNumber" ) 
		  int findDifference(int ssnNumber);
		  
		 

	
	
}
