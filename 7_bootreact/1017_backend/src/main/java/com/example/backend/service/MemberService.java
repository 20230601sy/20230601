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
import org.springframework.util.LinkedMultiValueMap;
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

	@Value("${kakako.default.password}")
	private String kakaoPassword;
	
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
	
	public String getKakaoAccessToken(String code) {
		HttpHeaders header = new HttpHeaders();
		header.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("grant_type", "authorization_code");
		body.add("client_id", "e5d93009f7ec792c5e61f011892f46ee");
		body.add("redirect_uri", "http://localhost:3000/oauth/kakao");
		body.add("code", code);
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, header);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange("https://kauth.kakao.com/oauth/token", HttpMethod.POST, request, String.class);
		String json = response.getBody();
//		System.out.println(json);
//		{	"access_token":"Ox6QYcRl9U3WxBr1rwguhdxsoUxLbuCAAHoKKiUOAAABi0V9NNT-oZq-Jypvmw",
//			"token_type":"bearer",
//			"refresh_token":"9sXI3PPhnlL001t4VmqRX02i0y6wCfnvCpMKKiUOAAABi0V9NNH-oZq-Jypvmw",
//			"expires_in":21599,
//			"scope":"account_email profile_nickname",
//			"refresh_token_expires_in":5183999	}
		
		Gson gson = new Gson();
		Map<?, ?> data = gson.fromJson(json, Map.class);
		return (String)data.get("access_token");
	}
	
	public Member kakaoLogin(String accessToken) {
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "Bearer " + accessToken);
	    header.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(header);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange("https://kapi.kakao.com/v2/user/me", HttpMethod.POST, request, String.class);
//		System.out.println(response.getBody());
//		{	"id":3101019923,
//			"connected_at":"2023-10-19T01:11:55Z",
//			"properties":{"nickname":"SY"},
//			"kakao_account":{	"profile_nickname_needs_agreement":false,
//								"profile":{"nickname":"SY"},
//								"has_email":true,
//								"email_needs_agreement":false,
//								"is_email_valid":true,
//								"is_email_verified":true,
//								"email":"16s@kakao.com"	}	}
		String json = response.getBody();
		Gson gson = new Gson();
		Map<?, ?> data = gson.fromJson(json, Map.class);
		String username = (String) ((Map<?, ?>) data.get("properties")).get("nickname");
		String email = (String) ((Map<?, ?>) data.get("kakao_account")).get("email");
		Member member = new Member();
		member.setUsername(username);
		member.setEmail(email);
		member.setPassword(kakaoPassword);
		return member;
	}
}