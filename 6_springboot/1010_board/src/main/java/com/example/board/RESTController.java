package com.example.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {
	
	@Autowired
	private UserDAO userDAO;
	
	@GetMapping("/rest")
	public User getRest() {
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
	
	@PostMapping("/rest")
	public String postRest(User user) {
//	public String postRest(@RequestBody User user) {
		userDAO.insertUser(user);
		return user.toString();
	}
	
	@PutMapping("/rest")
	public String putRest(@RequestBody User user, @RequestParam int id) {
		return user.toString() + " → " + id;
	}

	@DeleteMapping("/rest")
	public String deleteRest(@RequestParam int id) {
		return id+"delete요청";
	}
	

	@PatchMapping("/rest")
	public String patchRest() {
		User user = new User();
		user.setUsername("홍길동");
		user.setPassword("1234");
		user.setEmail("abc@naver.com");
		userDAO.insertUser(user);
		return user.toString();
	}
	
	@DeleteMapping("/rest2")
	public void delete(int id) {
		userDAO.deleteUser(id);
	}
	@PostMapping("/rest2")
	public void update(User user) {
		userDAO.updateUser(user);
	}
}
