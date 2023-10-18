package com.example.backend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.domain.Member;
import com.example.backend.domain.MemberCredentials;
import com.example.backend.jwt.JwtService;
import com.example.backend.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody Member member) {
//		System.out.println(member);
		memberService.signup(member);
		return new ResponseEntity<>("회원가입 완료", HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody MemberCredentials cred) {
		return memberService.getResponseEntity(cred.getUsername(), cred.getPassword());
	}
	
	@PostMapping("/oauth/google")
	public ResponseEntity<?> googleLogin(@RequestBody Map<String, String> accessToken) {
//		memberService.googleLogin(accessToken.get("accessToken"));
//		System.out.println(accessToken);
		Member member = memberService.googleLogin(accessToken.get("accessToken"));
//		System.out.println(member);
		Member findMember = memberService.getMember(member.getUsername());
		if(findMember.getUsername() == null) {
			memberService.signup(member);
		}
		return memberService.getResponseEntity(member.getUsername(), member.getPassword());
	}
}
