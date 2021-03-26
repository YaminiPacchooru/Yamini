package com.Exception;


import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RecordExceptionController {
	
	
	
	 @ExceptionHandler(RecordNotFoundException.class)
	    public ResponseEntity<Object> handleRecordNotFoundException(
	    		RecordNotFoundException ex, WebRequest request) {

	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", "Not Eligible for applying loan since credit score less than 700");

	        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	    }

	 @ExceptionHandler(DateException.class)
	    public ResponseEntity<Object> handleDateException(
	    		DateException ex, WebRequest request) {

	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", " you already applied. Apply after 30 days ");

	        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	    }
}