package com.study.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class SecurityTest {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private DataSource dataSource;
	
/*
	@Test
	public void test() {
		String sql = "insert into tbl_member(userid, userpw, username) values(?,?,?)";
		for(int i=0; i<10; i++) {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = dataSource.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(2, passwordEncoder.encode("a"+i)); // 해싱해서 생성되는 거라 독한?사람에게는 이것도 뚫린다심...모자라서...앞뒤로 랜덤스트링 개발자만 알도록 넣기도 한다심...
				if(i < 8) {
					ps.setString(1, "user"+i);
					ps.setString(3, "사용자"+i);
				} else if(i == 8) {
					ps.setString(1, "manager"+i);
					ps.setString(3, "관리자"+i);
				} else {
					ps.setString(1, "admin"+i);
					ps.setString(3, "운영자"+i);
				}
				ps.execute();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
*/
	@Test
	public void test() {
		String sql = "insert into tbl_member_auth values(?,?)";
		for(int i=0; i<10; i++) {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = dataSource.getConnection();
				ps = conn.prepareStatement(sql);
				if(i < 8) {
					ps.setString(1, "user"+i);
					ps.setString(2, "ROLE_MEMBER");
				} else if(i == 8) {
					ps.setString(1, "manager"+i);
					ps.setString(2, "ROLE_MEMBER");
				} else {
					ps.setString(1, "admin"+i);
					ps.setString(2, "ROLE_ADMIN");
				}
				ps.execute();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
