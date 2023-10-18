package com.example.backend.jwt;

import java.security.Key;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {
	static final long EXPIRATIONTIME = 24 * 60 * 60 * 1000; // 토큰 만료 시간, 보통은 30분~1시간
	static final String PREFIX = "Bearer"; // jwt에서 헤더에 사용할 접두어
	static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // 서명에 사용될 암호화시킨 key
	
	public String getToken(String username) { // jwt 발급해주는 메서드
		return Jwts.builder() // builder는 객체를 생성해줌
					.setSubject(username) // jwt 클레임 설정, 토큰 안에 정보가 들어가는 거 클레임이라고 함
					.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
					.signWith(key) // 서명
					.compact(); // String 타입으로!
	}
	
	public String getAuthUser(HttpServletRequest request) { // 토큰 추출해서 검사, 사용자 이름을 리턴
		String token = request.getHeader(HttpHeaders.AUTHORIZATION);
		if(token != null) {
			String username = Jwts.parserBuilder()
									.setSigningKey(key)
									.build()
									.parseClaimsJws(token.replace(PREFIX, ""))
									.getBody()
									.getSubject();
			if(username != null)
				return username;
		}
		return null;
	}
}
