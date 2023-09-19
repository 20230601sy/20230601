package com.test.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TestSample {
	@Autowired
	private Restaurant restaurant;
	
	@Test // 테스트 실행 시켰을 때 작동할 메서드라는 것을 알려주는 어노테이션
	public void test() {
		assertNotNull(restaurant); // junit 안에 있는 null인지 아닌지 판별하는 메서드
		log.info(restaurant);
		log.info("====================");
		log.info(restaurant.getChef());
	}
}
