package com.bwfspring.test.dao;

import org.apache.ibatis.annotations.Param;

public interface IUserDao {
	
	
	public void addUser(@Param("name") String name,@Param("password") String password,@Param("age") int age,@Param("sex") String sex);
}
