package com.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleServiceTest {
	
//	@Autowired
//	private SampleService sampleService;
//	
//	@Test
//	public void addTest() throws Exception {
//		log.info("결과 : " + sampleService.add("123", "456"));
//		/* log.info("결과 : " + sampleService.add("123", "456aa")); */
//	}
	
	@Autowired
	private SampleTxService sampleTxService;
	
	@Test
	public void insertTest() {
//		String str = "테스트";
//		String str = "테스트20바이트넘게추가시켜보기이러면 어떻게되는지 봐봐랑";
		String str = "트랜젝션 추가한다음 테스트20바이트넘게추가시켜보기이러면 어떻게되는지 봐봐랑";
		log.info("str 길이 : " + str.getBytes().length);
		sampleTxService.insertData(str);
	}

}
