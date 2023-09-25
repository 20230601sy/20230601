package com.board.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.board.domain.Paging;
import com.board.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTest {
	@Autowired
	private ReplyMapper replyMapper;
	
//	@Test
//	public void mapperTest() {
//		log.info(replyMapper);
//	}
	private Long[] bnoArr = { 2068L, 2067L, 2066L, 2065L, 2064L };
	
//	@Test
//	public void insert() {
//		for(int i=0; i<10; i++) {
//			ReplyVO vo = new ReplyVO();
//			vo.setBno(bnoArr[i%5]);
//			vo.setReply("댓글 내용 테스트" + i);
//			vo.setReplyer("댓글작성자" + i);
//			replyMapper.insert(vo);
//		}
//	}
	
//	@Test
//	public void read() {
//		log.info(replyMapper.read(1L));
//	}

//	@Test
//	public void delete() {
//		log.info(replyMapper.delete(10L));
//	}
	
//	@Test
//	public void update() {
//		ReplyVO vo = new ReplyVO();
//		vo.setRno(9L);
//		vo.setReply("댓글 수정 내용 테스트");
//		replyMapper.update(vo);
//	}
	@Test
	public void getListWithPaging() {
		replyMapper.getListWithPaging(new Paging(), bnoArr[0]).forEach(b->log.info(b));
	}
}
