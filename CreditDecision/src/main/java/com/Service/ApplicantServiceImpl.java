package com.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Repository.ApplicantRepository;
import com.Model.Applicant;

@Service

public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	public ApplicantRepository applicantRepository;

	public Applicant addApplicant(Applicant applicant){
		 return  applicantRepository.save(applicant);
	}
		
	
	@Override
	public long findBySsnNumberReturnStreams(int ssnNumber) {
		
		return  applicantRepository.findBySsnNumberReturnStreams(ssnNumber);
	}


}

