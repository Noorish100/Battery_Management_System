package com.exception;

import java.time.LocalDateTime;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	// Userlogin.exception's LoginException Handler

	@ExceptionHandler(BatteryException.class)
	public ResponseEntity<MyErrorMessage> customerExpHandler(BatteryException ie, WebRequest wr) {
		System.out.println("Inside customer exception handler");

		MyErrorMessage err = new MyErrorMessage(LocalDateTime.now(), ie.getMessage(), wr.getDescription(false));

		return new ResponseEntity<MyErrorMessage>(err, HttpStatus.BAD_REQUEST);

	}

	// to handle Not found exception
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorMessage> wrongUrl(NoHandlerFoundException nhf, WebRequest req) {
		MyErrorMessage err = new MyErrorMessage(LocalDateTime.now(), nhf.getMessage(), req.getDescription(false));

		ResponseEntity<MyErrorMessage> responseEntity = new ResponseEntity<>(err, HttpStatus.BAD_GATEWAY);

		return responseEntity;
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<MyErrorMessage> handleDataNotFountException(NotFoundException iun, WebRequest req) {

		MyErrorMessage message = new MyErrorMessage(LocalDateTime.now(), iun.getMessage(), req.getDescription(false));

		return new ResponseEntity<MyErrorMessage>(message, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorMessage> DataNotFountException(Exception iun, WebRequest req) {

		MyErrorMessage message = new MyErrorMessage(LocalDateTime.now(), iun.getMessage(), req.getDescription(false));

		return new ResponseEntity<MyErrorMessage>(message, HttpStatus.BAD_REQUEST);

	}

}
