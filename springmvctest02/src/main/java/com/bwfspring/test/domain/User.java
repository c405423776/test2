package com.bwfspring.test.domain;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class User {
	private int id;
	
	private String name;
	
	private String password;
	
	private int age;
	
	private String sex;
	
	
	public User() {
		super();
	}

	public User(String name,String password, int age, String sex) {
		super();
		this.name = name;
		this.password=password;
		this.age = age;
		this.sex = sex;
	}

	public User(int id, String name, String password,int age, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.password=password;
		this.age = age;
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
