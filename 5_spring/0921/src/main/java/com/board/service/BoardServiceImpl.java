package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.BoardVO;
import com.board.domain.Paging;
import com.board.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@Service // 이 클래스는 비즈니스 계층을 담당하는 클래스임을 명시
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public BoardVO get(Long bno) {
		return boardMapper.read(bno);
	}

	@Override
	public List<BoardVO> getList(Paging paging) {
		return boardMapper.getListWithPaging(paging);
	}

	@Override
	public void add(BoardVO vo) {
//		log.info("추가할 데이터 : " + vo);
		boardMapper.insertSelectKey(vo);
//		log.info("추가된 데이터 : " + vo);
	}

	@Override
	public boolean remove(Long bno) {
		return boardMapper.delete(bno)==1;
	}

	@Override
	public boolean modify(BoardVO vo) {
		return boardMapper.update(vo)==1;
	}

	@Override
	public int getTotal(Paging paging) {
		return boardMapper.getTotal(paging);
	}

}
