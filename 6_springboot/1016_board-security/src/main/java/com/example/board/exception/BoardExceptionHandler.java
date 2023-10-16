package com.example.board.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice // 공통적인 예외를 처리해주는 것임 다른 클래스에서 발생되는 예외를 여기서 처리하게 하라는 어노테이션
@RestController
public class BoardExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public String exceptionHandler(Exception e) {
		return "<h1>" + e.getMessage() + "</h1>";
	}
}
