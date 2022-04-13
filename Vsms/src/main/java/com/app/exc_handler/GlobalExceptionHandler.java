package com.app.exc_handler;

import java.time.LocalDateTime;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.custom_exceptions.UserHandlingException;
import com.app.dto.ErrorResponseDto;


//Centralized exception handling
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	//Exception Handling Method
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleRuntimeException(RuntimeException e) {
		System.out.println("in handle run time exc " + e);
		ErrorResponseDto resp = new ErrorResponseDto("Action failure!!!", LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
	}

	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<?> handleEmptyDataExcetpion(EmptyResultDataAccessException e) {
		System.out.println("in handle  exc " + e);
		ErrorResponseDto resp = new ErrorResponseDto(e.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
	}

	
	@ExceptionHandler(UserHandlingException.class)
	public ResponseEntity<?> handleUserHandlingException(UserHandlingException e) {
		System.out.println("in handle user exc " + e);
		ErrorResponseDto resp = new ErrorResponseDto(e.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
	}

	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
		HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("in handle invalid meth args ");
		StringBuilder sb = new StringBuilder("Validation Errors : ");
		ex.getBindingResult().getFieldErrors().forEach(e -> sb.append(e.getDefaultMessage()+"\n"));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ErrorResponseDto(sb.toString(), LocalDateTime.now()));
	}

}
