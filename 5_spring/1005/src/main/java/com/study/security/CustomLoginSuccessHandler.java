package com.study.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// authentication 안에 로그인한 사람 정보가 담김
		// 권한에 따라서 로그인 성공 시 자동으로 이동되는 페이지를 다르게
		// 권한은 여러개 부여할 수 있으므로...
		List<String> role = new ArrayList<>();
		authentication.getAuthorities().forEach(auth -> role.add(auth.getAuthority()));
		if(role.contains("ROLE_ADMIN")) {
			response.sendRedirect("/admin");
			return;
		}
		if(role.contains("ROLE_MEMBER")) {
			response.sendRedirect("/member");
			return;
		}
		response.sendRedirect("/");		
	}
	

}
