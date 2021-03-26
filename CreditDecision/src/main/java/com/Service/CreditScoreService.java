package com.Service;

import java.time.LocalDate;
import java.util.Date;

import com.Model.CreditScore;

public interface CreditScoreService {
	CreditScore addCreditScore(CreditScore creditScore);

	long findBySsnNumberReturnStream(int ssnNumber);

	LocalDate findDate(int ssnNumber);

	int findDifference(int ssnNumber); 

	CreditScore save(CreditScore creditScore);

	

	

}
