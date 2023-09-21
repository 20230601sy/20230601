package com.board.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.board.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {
	
	@Autowired
	private BoardService boardService; // 구현 클래스를 직접 의존성 주입하지 않음
	
//	@Test
//	public void addTest() {
//		BoardVO vo = new BoardVO();
//		vo.setTitle("add테스트 제목");
//		vo.setContent("add테스트 내용");
//		vo.setWriter("add테스트");
//		boardService.add(vo);
//		log.info("추가된 레코드 bno : " + vo.getBno());
//	}
	
//	@Test
//	public void getListTest() {
//		boardService.getList().forEach(b->log.info(b));
//	}
	
//	@Test
//	public void getTest() {
//		log.info(boardService.get((long)7));
//	}
	
//	@Test
//	public void removeTest() {
//		log.info(boardService.remove((long)5));
//	}
	
	@Test
	public void modifyTest() {
		BoardVO vo = new BoardVO();
		vo.setTitle("modify테스트 제목");
		vo.setContent("modify테스트 내용");
		vo.setWriter("modify테스트");
		vo.setBno((long)4);
		log.info(boardService.modify(vo));
	}
}
