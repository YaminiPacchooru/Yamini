package com.Model;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "creditscore")
public class CreditScore implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		int ssnNumber;
	long creditScore;
	
	@Column(name = "date")
	@JsonProperty("date") 
	@JsonFormat(pattern = "yyyy-MM-dd")
	
     LocalDate date;
	
	public int getSsnNumber() {
		return ssnNumber;
	}
	public void setSsnNumber(int ssnNumber) {
		this.ssnNumber = ssnNumber;
	}
	public long getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(long creditScore) {
		this.creditScore = creditScore;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public CreditScore(int ssnNumber, long creditScore,LocalDate date) {
		super();
		this.ssnNumber = ssnNumber;
		this.creditScore = creditScore;
		this.date = date;
	}
	public CreditScore() {
		super();
		
	}
	@Override
	public String toString() {
		return "CreditScore [ssnNumber=" + ssnNumber + ", creditScore=" + creditScore + ", date=" + date + "]";
	}
	
	
	
	
}
