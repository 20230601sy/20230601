package com.example.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.board.domain.User;
import com.example.board.dto.ResponseDTO;
import com.example.board.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/auth/insertUser")
	public String insertUser() {
		return "/user/insertUser";
	}
	
	@PostMapping("/auth/insertUser")
	@ResponseBody
	public ResponseDTO<?> insertUser(@RequestBody User user) {
//		User findUser = userService.getUser(user.getUsername());
		if(userService.getUser(user.getUsername()) == null) {
			userService.insertUser(user);
			return new ResponseDTO<>(HttpStatus.OK.value(), user.getUsername() + " 회원 가입 완료");
		} 
		else
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), user.getUsername() + " 은 이미 가입된 회원임");
	}
	
	@GetMapping("/auth/login")
	public String login() {
		return "/user/login";
	}
	@PostMapping("/auth/login")
	@ResponseBody
	public ResponseDTO<?> login(@RequestBody User user, HttpSession session) {
		User findUser = userService.getUser(user.getUsername());
		if(findUser == null)
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "잘못된 아이디");
		
		if (findUser.getPassword().equals(user.getPassword())) {
			session.setAttribute("principal", findUser); // user를 담으면 안돼~
			return new ResponseDTO<>(HttpStatus.OK.value(), user.getUsername() + "님 환영합니다.");
		}
		
		return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), user.getUsername() + " 비번 틀림");
	}
	
	@GetMapping("/auth/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}