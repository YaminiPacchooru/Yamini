package com.Service;





import javax.validation.Valid;



import com.Model.Applicant;

public interface ApplicantService {

	
	Applicant addApplicant(@Valid Applicant applicant);



	long findBySsnNumberReturnStreams(int ssnNumber);

	
}
