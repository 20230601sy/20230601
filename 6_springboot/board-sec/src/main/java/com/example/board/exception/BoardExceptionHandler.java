package com.example.board.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class BoardExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public String exceptionHandler(Exception e) {
		return "<h1>" + e.getMessage() + "</h1>";
	}
	
}
