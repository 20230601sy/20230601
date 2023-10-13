package com.example.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BoardWebMvcConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthInterceptor())
				.addPathPatterns("/", "/post/**"); 
		// 일단은 적용되는 페이지를 / 로 해둔 거... 변경 예정, 추가하려면 .addPathPatterns("/xxx") 메서드 체이닝 추가해주면 됨
	}
}
