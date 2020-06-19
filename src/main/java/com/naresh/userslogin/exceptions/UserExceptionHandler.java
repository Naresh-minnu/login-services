package com.naresh.userslogin.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.naresh.userslogin.model.response.ErrorMessage;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){
		
		String errorMsgDescription = ex.getLocalizedMessage();
		
		if(errorMsgDescription == null) {
			errorMsgDescription = ex.toString();
		}
		ErrorMessage errorMsg = new ErrorMessage(new Date(), errorMsgDescription);
		
		return new ResponseEntity<>(errorMsg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value= {NullPointerException.class, UserServiceException.class})
	public ResponseEntity<Object> handleSpecificException(Exception ex, WebRequest request){
		
		String errorMsgDescription = ex.getLocalizedMessage();
		
		if(errorMsgDescription == null) {
			errorMsgDescription = ex.toString();
		}
		ErrorMessage errorMsg = new ErrorMessage(new Date(), errorMsgDescription);
		
		return new ResponseEntity<>(errorMsg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
