package com.Contoller;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Exception.DateException;
import com.Exception.RecordNotFoundException;
import com.Model.Applicant;
import com.Model.CreditScore;
import com.Service.ApplicantService;
import com.Service.CreditScoreService;

@RestController
public class ApplicantController {

	@Autowired
	public ApplicantService applicantService;
	@Autowired
	public CreditScoreService creditScoreService;

	@RequestMapping(value = "/applicant", method = RequestMethod.POST)
	public Applicant createApplicant(@Valid @RequestBody Applicant applicant) {
		
        return this.applicantService.addApplicant(applicant);
	}

	@RequestMapping(value = "/creditscore", method = RequestMethod.POST)
	public CreditScore addCreditScore(@RequestBody(required = false) CreditScore creditScore) {
		return this.creditScoreService.addCreditScore(creditScore);
	}

	@RequestMapping(value = "/getCreditScore/{ssnNumber}", method = RequestMethod.GET)
	public ResponseEntity<Object> checkCreditScore(@PathVariable("ssnNumber") int ssnNumber, @RequestBody CreditScore creditScore) throws RecordNotFoundException {

		long creditscore = creditScoreService.findBySsnNumberReturnStream(ssnNumber);
		long currentAnnualIncome=applicantService.findBySsnNumberReturnStreams(ssnNumber);
		long santionedLoanamount ;
		LocalDate date=creditScoreService.findDate(ssnNumber);
		
	 
	       if(date.compareTo(LocalDate.now())<0) {
				
		     if (creditscore > 700) {
		    	 
		     santionedLoanamount = currentAnnualIncome / 2;
			System.out.println(santionedLoanamount);
			
			creditScore.setDate(LocalDate.now());
			creditScoreService.save(creditScore);
			
		     } else {

			throw new RecordNotFoundException();
		     }
		     
		  }else {
			  throw new DateException();
		  }
		return new ResponseEntity<>("printing santionedLoanamount:"+santionedLoanamount, HttpStatus.OK);
	}

}
