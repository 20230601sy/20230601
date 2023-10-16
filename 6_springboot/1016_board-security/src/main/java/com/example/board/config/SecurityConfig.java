package com.example.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
			.antMatchers("/webjars/**", "/js/**", "/img/**", "/", "/auth/**", "/h2-console/**") // 접근 가능한 url, 경로 설정
			.permitAll() // 인증되지 않은 사용자에게 허용
			.anyRequest().authenticated(); // 나머지 요청에 대해서는 인증된 사용자만 접근 가능하게 설정
		
		http.headers().frameOptions().disable();
		// h2-console iframe x 표시 나오는 거 때문에 비활성화, 오라클할 때는 필요 없음
		http.csrf().disable();
		// 귀찮기도 하고 리액트하면 어차피 서버가 달라서 토큰 사용해서 주고받는 게 어렵다심...
		
		//  .and().formLogin() 안 끊고 할 수도 있음...
		http.formLogin().loginPage("/auth/login"); // .usernameParameter("uname").passwordParameter("pwd") 같은 거 할 수도 있지만 걍 username, password 사용하라심... 헤헷
		http.formLogin().loginProcessingUrl("/auth/securityLogin");
		
		http.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/");
		return http.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
	        throws Exception {
	    return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
