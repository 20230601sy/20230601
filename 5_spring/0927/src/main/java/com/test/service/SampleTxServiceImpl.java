package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.mapper.Sample1Mapper;
import com.test.mapper.Sample2Mapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class SampleTxServiceImpl implements SampleTxService {
	
	@Autowired
	private Sample1Mapper sample1Mapper;
	
	@Autowired
	private Sample2Mapper sample2Mapper;

	@Transactional  // 보통은 메서드에 붙여서 쓰지만, 클래스나 인터페이스에 붙여서 쓸 수도 있음. 우선순위는 메서드 1순위, 클래스 2순위, 인터페이스 3순위
	@Override
	public void insertData(String data) {
		log.info("1번 테이블에 추가");
		sample1Mapper.insert(data);

		log.info("2번 테이블에 추가");
		sample2Mapper.insert(data);
		
		log.info("완료");
	}

}
