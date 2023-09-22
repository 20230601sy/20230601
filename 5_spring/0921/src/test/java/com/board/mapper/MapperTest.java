package com.board.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.board.domain.BoardVO;
import com.board.domain.Paging;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTest {
	@Autowired
	private BoardMapper mapper;
	
//	@Test
//	public void testGetList() {
//		mapper.getList().forEach(b -> log.info(b));
//	}
	
//	@Test
//	public void testInsert() {
//		BoardVO vo = new BoardVO();
//		vo.setTitle("mapper테스트 제목");
//		vo.setContent("mapper테스트 내용");
//		vo.setWriter("mapper테스트");
//		mapper.insert(vo);
//		log.info(vo);
//	}
	
//	@Test
//	public void testInsertSelectKey() {
//		BoardVO vo = new BoardVO();
//		vo.setTitle("mapper테스트 제목");
//		vo.setContent("mapper테스트 내용");
//		vo.setWriter("mapper테스트");
//		mapper.insertSelectKey(vo);
//		log.info(vo);
//	}
	
//	@Test
//	public void testRead() {
//		BoardVO vo = mapper.read((long) 2);
//		log.info(vo);
//	}

//	@Test
//	public void testDelete() {
//		int result = mapper.delete((long) 6);
//		log.info(result);
//	}
	
//	@Test
//	public void testUpdate() {
//		BoardVO vo = new BoardVO();
//		vo.setBno((long) 7);
//		vo.setTitle("mapper테스트 new제목");
//		vo.setContent("mapper테스트 new내용");
//		vo.setWriter("mapper new테스트");
//		log.info(mapper.update(vo));
//		log.info(vo);
//	}
	
	@Test
	public void testPaging() {
		Paging paging = new Paging(5, 50);
		mapper.getListWithPaging(paging).forEach(b->log.info(b));;
	}
}
