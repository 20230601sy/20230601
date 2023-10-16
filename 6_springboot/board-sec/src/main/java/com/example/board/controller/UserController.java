package com.example.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.domain.RoleType;
import com.example.board.domain.User;
import com.example.board.dto.ResponseDTO;
import com.example.board.dto.UserDTO;
import com.example.board.exception.BoardException;
import com.example.board.repository.UserRepository;
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
	public ResponseDTO<?> insertUser(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult) {
		
		User user = modelMapper.map(userDTO, User.class);
		
//		이미 가입된 회원이면 그 회원정보가 들어있거나
//		가입되지 않은 회원이면 비어있는 user객체가 들어있음
		User findUser = userService.getUser(user.getUsername());
		
		if(findUser.getUsername() == null) {
			userService.insertUser(user);
			
			return new ResponseDTO<>(HttpStatus.OK.value(), user.getUsername() + "회원 가입 완료");
		} else {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), user.getUsername() + "은 이미 가입된 회원임");
		}
		
	}
	
	@GetMapping("/auth/login")
	public String login() {
		return "/user/login";
	}
	
	@GetMapping("/user/updateUser")
	public String updateUser() {
		return "/user/update";
	}
	
	@PutMapping("/user")
	public @ResponseBody ResponseDTO<?> updateUser(@RequestBody User user) {
		userService.updateUser(user);
		
		return new ResponseDTO<>(HttpStatus.OK.value(), "수정 완료");
	}
	
//	@Autowired
//	private UserRepository userRepository;
//	
//	@PostMapping("/user")
//	public String insertUser(@RequestBody User user) {
//		user.setRole(RoleType.USER);
//		userRepository.save(user);
//		
//		return user.getUsername() + " 회원가입 성공";
//	}
//	
////  전달받은 id에 해당하는 레코드를 조회
//	@GetMapping("/user/get/{id}")
//	public User getUser(@PathVariable int id) {
//		User user = userRepository.findById(id).orElseThrow(() -> {
//			return new BoardException(id + "번 회원은 없음");
//		});
//		
//		return user;
//	}
//	
//	
//	@PutMapping("/user")
//	public String updateUser(@RequestBody User user) {
//		
//		User findUser = userRepository.findById(user.getId()).orElseThrow(() -> {
//			return new BoardException(user.getId() + "번 회원은 없음");
//		});
//		
//		findUser.setUsername(user.getUsername());
//		findUser.setPassword(user.getPassword());
//		findUser.setEmail(user.getEmail());
//		
//		userRepository.save(findUser);
//		
//		return "수정완료";
//	}
//	
//	@DeleteMapping("/user/{id}")
//	public String deleteUser(@PathVariable int id) {
//		
//		userRepository.deleteById(id);
//		
//		return "삭제완료";
//	}
//	
//	@GetMapping("/user/list")
//	public List<User> getUserList() {
//		List<User> userList = userRepository.findAll();
//		
//		return userList;
//	}
	
	
}
