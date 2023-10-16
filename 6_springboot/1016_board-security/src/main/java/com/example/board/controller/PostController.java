package com.example.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.board.domain.Post;
import com.example.board.domain.User;
import com.example.board.dto.PostDTO;
import com.example.board.dto.ResponseDTO;
import com.example.board.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/post/insertPost")
	public String insertPost() {
		return "/post/insertPost";
	}
	
	@PostMapping("/post/insertPost")
	public @ResponseBody ResponseDTO<?> insertPost(@Valid @RequestBody PostDTO postDTO, BindingResult bindingResult, HttpSession session) {
//		if(bindingResult.hasErrors()) {
//			Map<String, String> errorMap = new HashMap<>();
//			for(FieldError error : bindingResult.getFieldErrors())
//				errorMap.put(error.getField(), error.getDefaultMessage());
//			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), errorMap);
//		}
		Post post = modelMapper.map(postDTO, Post.class);
		post.setUser((User)session.getAttribute("principal"));
		postService.insertPost(post);
		return new ResponseDTO<>(HttpStatus.OK.value(), "새 글 등록 완료");
	}
	
	@GetMapping("/post/{id}")
	public String getPost(@PathVariable int id, Model model) {
		Post post = postService.getPost(id);
		if(post == null)
			return "redirect:/";
		model.addAttribute("post", post);
		return "/post/getPost";
	}
	
	@GetMapping("/post/updatePost/{id}")
	public String updatePost(@PathVariable int id, Model model) {
		Post post = postService.getPost(id);
		if(post == null)
			return "redirect:/";
		model.addAttribute("post", post);
		return "/post/updatePost";
	}
	@PutMapping("/post")
	public @ResponseBody ResponseDTO<?> updatePost(@RequestBody Post post) {
		if(postService.updatePost(post))
			return new ResponseDTO<>(HttpStatus.OK.value(), "수정 완료");
		return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "수정 실패");
	}
	@DeleteMapping("/post/{id}")
	public @ResponseBody ResponseDTO<?> deletePost(@PathVariable int id) {
		postService.deletePost(id);
		return new ResponseDTO<>(HttpStatus.OK.value(), "삭제 완료");
	}
}
