package com.example.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.UserDAO;
import com.example.board.domain.User;

@RestController
public class RESTController {
	
	@GetMapping("/rest0")
	public String getRest0() {
		return "get요청";
	}
	@PostMapping("/rest0")
	public String postRest0() {
		return "post요청";
	}
	@PutMapping("/rest0")
	public String putRest0() {
		return "put요청";
	}
	@DeleteMapping("/rest0")
	public String deleteRest0() {
		return "delete요청";
	}
	
	@GetMapping("/rest1")
	public User getRest1() {
		// 기존 방법
		// User user = new User(1, "고길동", "abc", "aaa@naver.com");
		User user2 = User.builder()
						.id(2)
						.username("홍길동")
						.password("1234")
						.email("qwer@gmail.com")
						.build();
		return user2;
	}
	
	@PostMapping("/rest1")
	public String postRest1(User user) {
//	public String postRest1(@RequestBody User user) {
		return user.toString();
	}
	
	@PutMapping("/rest1")
	public String putRest1(@RequestBody User user, @RequestParam int id) {
		return user.toString() + " → " + id;
	}

	@DeleteMapping("/rest1")
	public String deleteRest1(@RequestParam int id) {
		return id+"delete요청";
	}
	
	@Autowired
	private UserDAO userDAO;

	@PatchMapping("/rest1")
	public String patchRest1() {
		User user = new User();
		user.setUsername("홍길동");
		user.setPassword("1234");
		user.setEmail("abc@naver.com");
		userDAO.insertUser(user);
		return user.toString();
	}
	
	@PostMapping("/rest2")
	public String insert(User user) {
		userDAO.insertUser(user);
		return user.toString();
	}
	@DeleteMapping("/rest2")
	public void delete(int id) {
		userDAO.deleteUser(id);
	}
	@PutMapping("/rest2")
	public void update(User user) {
		userDAO.updateUser(user);
	}
	@PostMapping("/rest3")
	public User select(String username) {
//		System.out.println(username + "요청 받음");
		return userDAO.getUser(username);
	}
	@GetMapping("/rest4")
	public List<User> selectAll() {
//		System.out.println("요청 받음");
		return userDAO.getUserList();
	}
}