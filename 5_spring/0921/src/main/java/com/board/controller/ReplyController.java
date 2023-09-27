package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.board.domain.PageReplyDTO;
import com.board.domain.Paging;
import com.board.domain.ReplyVO;
import com.board.service.ReplyService;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/replies")
@Log4j
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	
	@PostMapping(value="/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE}) // consumes : client가 json 형태로 보낼 거라고 설정
	public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
		int insertCount = replyService.insert(vo);
		return insertCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
	}
//	postman 테스트
//	post 요청 http://localhost:8181/replies/new
//	body - raw - json
//	{
//	   "bno" : "2068",
//	   "reply" : "댓글추가 컨트롤러 테스트",
//	   "replyer" : "컨트롤러"
//	}
	
//	@GetMapping(value="/pages/{bno}/{page}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
//	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("page") int page, @PathVariable("bno") Long bno){
//		Paging paging = new Paging(page, 10);
//		return new ResponseEntity<>(replyService.getList(paging, bno), HttpStatus.OK);
//	}
//	get 요청 http://localhost:8181/replies/pages/2068/1 // body - none
//	get 요청 http://localhost:8181/replies/pages/2068/1.json // body - none

	@GetMapping(value="/pages/{bno}/{page}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<PageReplyDTO> getList(@PathVariable("page") int page, @PathVariable("bno") Long bno){
		Paging paging = new Paging(page, 10);
		return new ResponseEntity<>(replyService.getListPage(paging, bno), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{rno}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno) {
		return new ResponseEntity<>(replyService.get(rno), HttpStatus.OK);
	}
//	get 요청 http://localhost:8181/replies/1.json
	
	@DeleteMapping(value= "/{rno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno) {
		return replyService.remove(rno) == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
	}
//	delete 요청 http://localhost:8181/replies/1.json
	
	@PutMapping(value="/{rno}", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@PathVariable("rno") Long rno, @RequestBody ReplyVO vo) {
		vo.setRno(rno);
		return replyService.modify(vo) == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
	}
//	postman 테스트
//	put 요청 http://localhost:8181/replies/7
//	body - raw - json
//	{
//	   "reply" : "댓글 수정 테스트",
//	}
}
