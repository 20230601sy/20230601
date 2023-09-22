package com.board.service;

import java.util.List;

import com.board.domain.BoardVO;
import com.board.domain.Paging;

public interface BoardService {

	// 특정 레코드를 조회
	public BoardVO get(Long bno);
	// 전체 레코드를 조회
	public List<BoardVO> getList(Paging paging);
	// 레코드 추가
	public void add(BoardVO vo);
	// 레코드 삭제
	public boolean remove(Long bno);
	// 레코드 수정
	public boolean modify(BoardVO vo);
	// 전체 레코드 수
	public int getTotal(Paging paging);
}
