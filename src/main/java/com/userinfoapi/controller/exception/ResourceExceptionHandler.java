package com.userinfoapi.controller.exception;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<StandardError> validation(ConstraintViolationException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError();
		err.setStatus("UNABLE_TO_VOTE");
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<StandardError> erroDeSistema(Exception e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		StandardError err = new StandardError();
		err.setError("Erro de Sistema.");
		err.setMensagem(e.getMessage());
		return ResponseEntity.status(status).body(err);
	}

}
