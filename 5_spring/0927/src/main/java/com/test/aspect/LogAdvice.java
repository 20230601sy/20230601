package com.test.aspect; // 보통은 aspect 보다는 advice 라고 한다심...

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
@Aspect
public class LogAdvice {
	// execution내부 *  리턴타입                 상속클래스 포함  메서드 이름 (매개변수) .. 은 매개변수가 있을 수도 있고 없을 수도 있다는 의미 이따가 다시 정리해주신다심
	@Before("execution(* com.test.service.SampleService*.*(..))") // Before 어노테이션은 특정 기능이 실행되기 전에 해달라는 의미, execution은 표현식 작성하는 공간을 마련해줌, 매개변수는 어떤 거 실행할 건지인데, 메서드를 잡음 특정 패키지, 클래스, 메서드 경로 다 잡아 줘야 함.
	public void logBefore() {
		log.info("==================== advice ===================="); // 실행시킬 코드가 advice임
	}

	// parameter 빼오기
	@Before("execution(* com.test.service.SampleService*.add(String, String)) && args(str1, str2)") // (.., ..) 매개변수 2개, 자료형은 상관 없음
	public void logBeforeParam(String str1, String str2) {
		log.info("==================== " + str1 + " + " + str2 + " ====================");
	}
	
	// 예외처리, 이걸 한다고 해서 예외가 넘어가지지는 않음... 걍 로그..
	@AfterThrowing(pointcut = "execution(* com.test.service.SampleService*.*(..))", throwing="exception")
	public void logException(Exception exception) {
		log.info("==================== 예외발생 =====================");
		log.info(exception);
	}
	
	@Around("execution(* com.test.service.SampleService*.*(..))") // 전후
	public Object logTime(ProceedingJoinPoint pj) {
		// 전에 실행할 코드
		// 메서드 직접 실행
		// 후에 실행할 코드
		long start = System.currentTimeMillis();
		log.info("pj : " + pj);
		log.info("매개변수들 : " + Arrays.toString(pj.getArgs()));
		Object result = null;
		try {
			result = pj.proceed();
		} catch(Throwable e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info(end-start + "ms");
		return result;
	}
}
