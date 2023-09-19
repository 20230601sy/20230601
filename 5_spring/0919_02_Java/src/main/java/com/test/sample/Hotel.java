package com.test.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// import lombok.AllArgsConstructor;
import lombok.Data;

@Component
@Data
// @AllArgsConstructor // 모든 멤버변수를 매개변수로 받는 생성자를 생성해줌. public Hotel(Chef chef) 생성... 생성자로 하든가 lombok 어노테이션 사용하든가...
// @NoArgsConstructor // 기본생성자를 생성해줌
// @RequiredArgsConstructor // final이 붙은 멤버변수를 매개변수로 받는 생성자를 생성해줌, final 붙이기 싫으면 해당 변수 위에 @NonNull 어노테이션 붙여주면 됨...
public class Hotel {
	private Chef chef;
	public Hotel(Chef chef) { // 묵시적 의존성
//	public Hotel(@Autowired Chef chef) { // 명시적 의존성
//	public Hotel(@Autowired(required = false) Chef chef) { // 의존성 주입 안 하고 싶을 경우 근데 이건 지금 확인은 안되는...
		this.chef = chef;
	}
}

/*
 * public class Hotel {
 * 	@autowired
 * 	private Chef chef;
 * 	@autowired
 * 	private Restaurant restaurant;
 *  대신에
 *  
 * 	@RequiredArgsConstructor 
 *  public class Hotel {
 * 	private final Chef chef;
 * 	private final Restaurant restaurant;
 *  해도 의존성 주입됨
 */