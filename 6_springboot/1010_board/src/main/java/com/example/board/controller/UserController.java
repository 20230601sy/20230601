package com.example.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.board.domain.User;
import com.example.board.dto.ResponseDTO;
import com.example.board.dto.UserDTO;
import com.example.board.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/auth/insertUser")
	public String insertUser() {
		return "/user/insertUser";
	}
	
	@PostMapping("/auth/insertUser")
	@ResponseBody
//	public ResponseDTO<?> insertUser(@RequestBody User user) {
	public ResponseDTO<?> insertUser(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult) { // BindingResult는 무조건 @Valid UserDTO 바로 뒤에 와야 함
//		if(bindingResult.hasErrors()) {
//			Map<String, String> errorMap = new HashMap<>();
//			for(FieldError error : bindingResult.getFieldErrors()) // getFieldErrors -s 로 끝나야 함 자동완성 주의!
//				errorMap.put(error.getField(), error.getDefaultMessage());
//			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), errorMap);
//		}
		User user = modelMapper.map(userDTO, User.class);
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