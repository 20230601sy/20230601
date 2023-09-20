package com.test.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages = {"com.test.controller"})
public class ServletConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 정적파일을 잡아주는 메서드
		// Handler 요청
		// /resources/aa/bb/ ** 붙은 거는 하위까지 다 처리해주기 위함. *만 붙으면 /resources/ㅇㅇ까지 밖에 안되잖슴 
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// 페이지 이동을 해주는 세팅... 어디에 들어있는 거를 화면단으로 내보내겠다 설정해줘야 함.
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views/"); // jsp 파일 경로 세팅, 앞쪽 경로는 알아서 잡아준다심.
		bean.setSuffix(".jsp"); // 확장자 자동으로 붙이게...
		registry.viewResolver(bean);
	}
	
	@Bean
	public CommonsMultipartResolver getResolver() throws IOException {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");
		resolver.setMaxUploadSize(10*1024*1024);
		resolver.setMaxUploadSizePerFile(2*1024*1024);
		resolver.setUploadTempDir(new FileSystemResource("D:\\Y\\20230601ezen\\5_spring\\upload\\tmp"));
		resolver.setMaxInMemorySize(10*1024*1024);
		return resolver;
	}

}
