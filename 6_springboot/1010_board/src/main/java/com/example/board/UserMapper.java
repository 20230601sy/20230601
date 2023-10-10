package com.example.board;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
	
	@Insert("insert into users values((select nvl(max(id), 0)+1 from users), #{username}, #{password}, #{email})")
	public void insertUser(User user);
	
	@Update("update users set password=#{password}, email=#{email} where id=#{id}")
	public void updateUser(User user);
	
	@Delete("delete from users where id=#{id}")
	public void deleteUser(int id);
	
	@Select("select * from users where username=#{username}")
	public User getUser(String username);
	
	@Select("select * from users order by username desc")
	public List<User> getUserList();
}