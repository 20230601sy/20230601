package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.domain.BoardAttachVO;
import com.board.domain.BoardVO;
import com.board.domain.Paging;
import com.board.mapper.BoardAttachMapper;
import com.board.mapper.BoardMapper;

import lombok.AllArgsConstructor;

@Service // 이 클래스는 비즈니스 계층을 담당하는 클래스임을 명시
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private BoardMapper boardMapper;
	private BoardAttachMapper boardAttachMapper;
	
	@Override
	public BoardVO get(Long bno) {
		return boardMapper.read(bno);
	}

	@Override
	public List<BoardVO> getList(Paging paging) {
		return boardMapper.getListWithPaging(paging);
	}

	@Transactional
	@Override
	public void add(BoardVO vo) {
//		log.info("추가할 데이터 : " + vo);
		boardMapper.insertSelectKey(vo);
//		log.info("추가된 데이터 : " + vo);
		if(vo.getAttachList() == null || vo.getAttachList().size() <= 0)
			return;
		vo.getAttachList().forEach(attach -> {
			attach.setBno(vo.getBno());
			boardAttachMapper.insert(attach);
		});
	}
	
	@Transactional
	@Override
	public boolean remove(Long bno) {
		boardAttachMapper.deleteAll(bno);
		return boardMapper.delete(bno)==1;
	}

	@Transactional
	@Override
	public boolean modify(BoardVO vo) {
		boolean result = boardMapper.update(vo)==1;
		if(result && vo.getAttachList() != null && vo.getAttachList().size() > 0) {
			boardAttachMapper.deleteAll(vo.getBno());
			vo.getAttachList().forEach(attach -> {
				attach.setBno(vo.getBno());
				boardAttachMapper.insert(attach);
			});
		}
		return result;
	}

	@Override
	public int getTotal(Paging paging) {
		return boardMapper.getTotal(paging);
	}

	@Override
	public List<BoardAttachVO> getAttachList(Long bno) {
		return boardAttachMapper.findByBno(bno);
	}

}
