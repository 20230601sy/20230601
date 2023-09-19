package com.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정 관련된 class 구나 알려주는 어노테이션 추가
@ComponentScan(basePackages = {"com.test.sample"}) // 의존성 주입을 위한 준비...<context:component-scan base-package="com.test.sample"></context:component-scan>랑 유사하지?...
public class RootConfig {
	
}
