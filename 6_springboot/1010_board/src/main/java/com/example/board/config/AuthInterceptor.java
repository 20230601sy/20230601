package com.example.board.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.example.board.domain.User;

public class AuthInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception { // 작동되는 시점을 controller 동작 전으로 하기 위해서 preHandle override, post는 controller 동작 후, afterxxx는 화면까지 다 구현하고 나서 
		
		HttpSession session = request.getSession();
		User principal = (User) session.getAttribute("principal");
		
		if(principal == null)
			response.sendRedirect("/auth/login");
		
		return true;
	}

}
