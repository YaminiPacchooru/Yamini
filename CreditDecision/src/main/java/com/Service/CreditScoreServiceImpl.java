package com.Service;


import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Model.CreditScore;

import com.Repository.CreditScoreRepository;
@Service
public class CreditScoreServiceImpl implements CreditScoreService {

	@Autowired
	public CreditScoreRepository creditScoreRepository;
	
	
	@Override
	public CreditScore addCreditScore(CreditScore creditScore) {
		
		return  this.creditScoreRepository.save(creditScore);
	}

	@Override
	public long findBySsnNumberReturnStream(int ssnNumber) {
	
		return this.creditScoreRepository.findBySsnNumberReturnStream(ssnNumber);
	}

	@Override
	public LocalDate findDate(int ssnNumber) {
		
		return creditScoreRepository.findDate(ssnNumber);
	}

	
	  @Override public int findDifference(int ssnNumber) {
	  
	  return creditScoreRepository.findDifference(ssnNumber); }
	 

	@Override
	public CreditScore save(CreditScore creditScore) {
		
		return creditScoreRepository.save(creditScore);
	}

	
	
	

	
	
}
