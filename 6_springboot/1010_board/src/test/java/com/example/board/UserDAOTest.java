package com.example.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDAOTest {
	@Autowired
	private UserDAO userDAO;
	
	@Test
	public void mapperTest() {
		User user = new User();
		user.setUsername("홍길동");
		user.setPassword("1234");
		user.setEmail("abc@naver.com");
		userDAO.insertUser(user);
	}
}
