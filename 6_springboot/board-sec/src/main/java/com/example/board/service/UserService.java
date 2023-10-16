package com.example.board.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.board.domain.RoleType;
import com.example.board.domain.User;
import com.example.board.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void insertUser(User user) {
		user.setRole(RoleType.USER);
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		userRepository.save(user);
	}
	
	public User getUser(String username) {
		User user = userRepository.findByUsername(username).orElseGet(() -> {
			return new User();
		});
		
		return user;
	}
	
	@Transactional
	public User updateUser(User user) {
		User oriUser = userRepository.findById(user.getId()).get();
		
		oriUser.setUsername(user.getUsername());
		oriUser.setPassword(passwordEncoder.encode(user.getPassword()));
		oriUser.setEmail(user.getEmail());
		
		return oriUser;
	}
	
}
