package com.Model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "applicant")
public class Applicant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	int ssnNumber;
	double loanAmount;
	long currentAnualIncome;
	public int getSsnNumber() {
		return ssnNumber;
	}
	public void setSsnNumber(int ssnNumber) {
		this.ssnNumber = ssnNumber;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public long getCurrentAnualIncome() {
		return currentAnualIncome;
	}
	public void setCurrentAnualIncome(long currentAnualIncome) {
		this.currentAnualIncome = currentAnualIncome;
	}
	public Applicant(int ssnNumber, double loanAmount, long currentAnualIncome) {
		super();
		this.ssnNumber = ssnNumber;
		this.loanAmount = loanAmount;
		this.currentAnualIncome = currentAnualIncome;
	}
	public Applicant() {
		super();
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (currentAnualIncome ^ (currentAnualIncome >>> 32));
		long temp;
		temp = Double.doubleToLongBits(loanAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ssnNumber;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Applicant other = (Applicant) obj;
		if (currentAnualIncome != other.currentAnualIncome)
			return false;
		if (Double.doubleToLongBits(loanAmount) != Double.doubleToLongBits(other.loanAmount))
			return false;
		if (ssnNumber != other.ssnNumber)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Applicant [ssnNumber=" + ssnNumber + ", loanAmount=" + loanAmount + ", currentAnualIncome="
				+ currentAnualIncome + "]";
	}

	
}