package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.domain.PageReplyDTO;
import com.board.domain.Paging;
import com.board.domain.ReplyVO;
import com.board.mapper.BoardMapper;
import com.board.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyMapper replyMapper;

	@Autowired
	private BoardMapper boardMapper;
	
	@Transactional
	@Override
	public int insert(ReplyVO vo) {
		boardMapper.updateReplyCnt(vo.getBno(), 1);
		return replyMapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		return replyMapper.read(rno);
	}

	@Transactional
	@Override
	public int remove(Long rno) {
		boardMapper.updateReplyCnt(replyMapper.read(rno).getBno(), -1);
		return replyMapper.delete(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		return replyMapper.update(vo);
	}

	@Override
	public List<ReplyVO> getList(Paging paging, Long bno) {
		return replyMapper.getListWithPaging(paging, bno);
	}

	@Override
	public PageReplyDTO getListPage(Paging paging, Long bno) {
		return new PageReplyDTO(replyMapper.getCountByBno(bno), replyMapper.getListWithPaging(paging, bno)); 
	}

}
