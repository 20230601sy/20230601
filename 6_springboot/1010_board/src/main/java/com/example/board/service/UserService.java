package com.example.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.domain.RoleType;
import com.example.board.domain.User;
import com.example.board.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void insertUser(User user) {
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
	
	public User getUser(String username) {
		// 강사님은 orElseGet 쓰시고 Controller에서 username이 null인지 확인하여 처리하게 구현하심...어차피 null 보낼 거면 걍...싶어서 orElse씀
//		orElse vs orElseGet
//		https://ysjune.github.io/posts/java/orelsenorelseget/
//		public T orElse(T other) {
//			return value != null ? value : other;
//		}
//		public T orElseGet(Supplier<? extends T> other) {
//			return value != null ? value : other.get();
//		}
		return userRepository.findByUsername(username).orElse(null);
	}
}
