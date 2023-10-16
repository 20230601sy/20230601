package com.example.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.UserDAO;
import com.example.board.domain.User;

@RestController
public class RESTController {
	
	@Autowired
	private UserDAO userDAO;
	
	@PostMapping("/rest")
	public List<User> getRest() {
		
		System.out.println("요청 받음");
		
		return userDAO.getUserList();
	
	}
	
//	@PostMapping("/rest")
//	public String postRest(@RequestBody User user) {
//		return user.toString();
//	}
	
	@PutMapping("/rest")
	public String putRest(@RequestBody User user, @RequestParam int id) {
		return user.toString() + "=>" + id;
	}
	
	@DeleteMapping("/rest")
	public String deleteRest(@RequestParam int id) {
		return id + "delete요청";
	}
	
}
