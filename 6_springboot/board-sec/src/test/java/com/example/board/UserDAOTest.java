package com.example.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.board.domain.User;

@SpringBootTest
public class UserDAOTest {
	
	@Autowired
	private UserDAO userDAO;
	
	@GetMapping("/rest")
	public String getRest() {
		User user = new User();
		user.setUsername("홍길동");
		user.setPassword("1234");
		user.setEmail("aa@aa.com");
		
		userDAO.insertUser(user);
		
		return user.toString();
	}

}
