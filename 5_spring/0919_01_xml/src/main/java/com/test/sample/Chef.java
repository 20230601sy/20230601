package com.test.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component // 스프링이 알아서 관리해주는...
@Data // 기본적인 게터 세터 다 자동으로 만들어줌 ㄷㄷㄷ Package Explorer에서 Chef.java - Chef 클릭해서 봐보삼. 세터만 만들고 싶으면 @setter 게터만 만들고 싶으면 @getter
public class Chef {
//	int a; // 이거 하면 자동으로 세터 게터 추가되는 거 볼 수 있음
}
