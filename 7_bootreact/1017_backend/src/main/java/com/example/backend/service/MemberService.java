package com.example.backend.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.backend.domain.Member;
import com.example.backend.domain.RoleType;
import com.example.backend.jwt.JwtService;
import com.example.backend.repository.MemberRepository;
import com.google.gson.Gson;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Value("${google.default.password}")
	private String googlePassword;
//
//	@Value("${kakao.default.password}")
//	private String kakaoPassword;
	
	public void signup(Member member) {
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		member.setRole(RoleType.USER);
		memberRepository.save(member);
	}
	
	public Member googleLogin(String token) {
		RestTemplate restTemplate = new RestTemplate();
		String userInfoEndPoint = "https://www.googleapis.com/oauth2/v1/userinfo";
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "Bearer " + token);
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(header);
		ResponseEntity<String> response = restTemplate.exchange(userInfoEndPoint, HttpMethod.GET, request, String.class);
//		System.out.println(response.getBody());
//		{
//			  "id": "109185014242808113771",
//			  "email": "20230601sy@gmail.com",
//			  "verified_email": true,
//			  "name": "SY Y",
//			  "given_name": "SY",
//			  "family_name": "Y",
//			  "picture": "https://lh3.googleusercontent.com/a/ACg8ocJ_SpTC4_ZZn57aq5BUU1Q9Y6h1E2j9SrXvWLzPGoSc=s96-c",
//			  "locale": "ko"
//		}
		String userInfo = response.getBody();
		Gson gson = new Gson();
		Map<?, ?> data = gson.fromJson(userInfo, Map.class);
		Member member = new Member();
		member.setUsername((String)data.get("name"));
		member.setEmail((String)data.get("email"));
		member.setPassword(googlePassword);
		return member;
//		return null;
	}
	
	public Member getMember(String username) {
		return memberRepository.findByUsername(username).orElse(new Member());
	}
	
	public ResponseEntity<?> getResponseEntity(String username, String password) {
		UsernamePasswordAuthenticationToken upaToken = new UsernamePasswordAuthenticationToken(username, password);
		Authentication auth = authenticationManager.authenticate(upaToken);
		String jwt = jwtService.getToken(auth.getName());
		return ResponseEntity.ok()
						.header(HttpHeaders.AUTHORIZATION, "Bearer " + jwt)
						.header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization")
						.build();
	}
}