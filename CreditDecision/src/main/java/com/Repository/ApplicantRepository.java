package com.Repository;








import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.Model.Applicant;


public interface ApplicantRepository extends CrudRepository<Applicant,Integer>{

	 


	 @Query( value= "select  a.currentAnualIncome from Applicant a where a.ssnNumber = :ssnNumber")
	Long findBySsnNumberReturnStreams(@Param("ssnNumber")int ssnNumber);

}
