package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.board.domain.BoardVO;
import com.board.domain.Paging;

public interface BoardMapper {
	// Board 테이블 전체 레코드를 조회하는 메서드
//	@Select("select * from tbl_board where bno > 0") // where bno > 0 의미 없는 건데 이거 > 사용하는 거 이슈가 있어서 넣어두자심
	public List<BoardVO> getList();
	public List<BoardVO> getListWithPaging(Paging paging);
	
	// Board 테이블에 레코드를 추가하는 메서드
	public void insert(BoardVO vo);
	// seq 통해서 들어가는 거...관련 테스트
	public void insertSelectKey(BoardVO vo);
	
	// Board 테이블의 특정 레코드를 조회하는 메서드
	public BoardVO read(Long bno);
	
	// Board 테이블의 특정 레코드를 삭제하는 메서드
	public int delete(Long bno);
	
	// Board 테이블에 특정 레코드를 수정하는 메서드
	// title, content, writer, updatedate
	public int update(BoardVO vo);
	
	public int getTotal(Paging paging);
}
