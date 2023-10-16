package com.example.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.board.domain.User;

@Repository
public class UserDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertUser(User user) {
		mybatis.insert("insertUser", user);
	}
	
	public void updateUser(User user) {
		mybatis.update("updateUser", user);
	}
	
	public void deleteUser(int id) {
		mybatis.delete("deleteUser", id);
	}
	
	public User getUser(String username) {
		return mybatis.selectOne("getUser", username);
	}
	
	public List<User> getUserList() {
		return mybatis.selectList("getUserList");
	}

}
