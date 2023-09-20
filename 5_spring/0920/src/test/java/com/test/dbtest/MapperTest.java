package com.test.dbtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.mapper.TimeMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTest {
	@Autowired
	private TimeMapper timeMapper;
	
	@Test
	public void mapperTest() {
		try {
			log.info(timeMapper.getTime());
			System.out.println("xml로 만든 거: " + timeMapper.getTime2());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
