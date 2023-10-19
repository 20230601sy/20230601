package com.example.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.domain.Board;
import com.example.backend.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/board")
	public ResponseEntity<?> newBoard(@RequestBody Board board) {
//		System.out.println(board);
		boardService.insertBoard(board);
		return new ResponseEntity<>("글작성 완료", HttpStatus.OK);
	}
	
	@GetMapping("/board")
	public ResponseEntity<?> getBoardList() {
		return new ResponseEntity<>(boardService.getBoardList(), HttpStatus.OK);
	}
	@GetMapping("/board/{id}")
	public ResponseEntity<?> getBoard(@PathVariable Integer id) {
		return new ResponseEntity<>(boardService.getBoard(id), HttpStatus.OK);		
	}
	@DeleteMapping("/board")
	public ResponseEntity<?> deleteBoard(@RequestParam Integer id) {
		boardService.deleteBoard(id);
		return new ResponseEntity<>(id + "번 게시글 삭제 완료", HttpStatus.OK);		
	}
}