package com.manoj.personal.trellolite.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.manoj.personal.trellolite.bean.ErrorBean;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<ErrorBean> handlingUserAlreadyExists(UserAlreadyExistsException e)
	{
		ErrorBean error= new ErrorBean();
		error.setErrorCode(400);
		error.setMessage("User Already Exists");
		
		return new ResponseEntity<ErrorBean>(error,HttpStatus.BAD_REQUEST);
	}
	
}
