package com.example.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.board.domain.Reply;
import com.example.board.domain.User;
import com.example.board.dto.ResponseDTO;
import com.example.board.service.ReplyService;

@Controller
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	@PostMapping("/reply/{postId}")
	public @ResponseBody ResponseDTO<?> insertReply(@PathVariable int postId, @RequestBody Reply reply, HttpSession session){
		replyService.insertReply(reply, postId, (User) session.getAttribute("principal"));
		return new ResponseDTO<>(HttpStatus.OK.value(), "댓글 등록 완료");
	}
	
	@DeleteMapping("/reply/{replyId}")
	public @ResponseBody ResponseDTO<?> deleteReply(@PathVariable int replyId, HttpSession session){
		replyService.deleteReply(replyId, (User) session.getAttribute("principal"));
		return new ResponseDTO<>(HttpStatus.OK.value(), "댓글 삭제 완료");
	}
	
	@PutMapping("/reply")
	public @ResponseBody ResponseDTO<?> updateReply(@RequestBody Reply reply, HttpSession session){
		replyService.updateReply(reply, (User) session.getAttribute("principal"));
		return new ResponseDTO<>(HttpStatus.OK.value(), "댓글 수정 완료");
	}
}