package com.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class CommonExceptionAdvice {
	
	@ExceptionHandler(Exception.class) // exception 종류 나누고 싶으면 IOException.class 뭐 이런 식으로 넣어주면 됨...
	public String exception(Exception e, Model model) {
		System.out.println("예외 발생 : " + e.getMessage());
		model.addAttribute("exception", e);
		return "errorPage"; // jsp 파일 이름...이따 만들거라심
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String pageNotFound(NoHandlerFoundException e) {
		return "pageNotFound";
	}
}
