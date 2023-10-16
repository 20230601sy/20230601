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
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/webjars/**", "/js/**", "/img/**", "/", "/auth/**", "/h2-console/**")
			.permitAll()
			.anyRequest().authenticated();
		
		http.headers().frameOptions().disable();
		
		http.csrf().disable();
		
		http.formLogin().loginPage("/auth/login");
		http.formLogin().loginProcessingUrl("/auth/securityLogin");
		
		http.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/");
		
		return http.build();
	}
	
	@Bean
	AuthenticationManager authentimManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
