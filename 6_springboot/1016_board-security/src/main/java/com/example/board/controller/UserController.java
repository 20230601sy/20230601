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
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/user/updateUser")
	public String updateUser() {
		return "/user/updateUser";
	}
	
	@PutMapping("/user")
	public ResponseDTO<?> updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return new ResponseDTO<>(HttpStatus.OK.value(), "수정 완료");
	}
}