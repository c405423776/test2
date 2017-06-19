package com.bwfspring.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bwfspring.test.domain.User;

/**
 * 知识点：
 * 1、掌握Restful API接口设计
 * 2、基于Spring MVC设计Restful API。并完成CRUD操作。
 * */
@Controller
@RequestMapping("/rest")
public class UesrTest {

	/**
	 * 用于添加一个User
	 * */
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public String addUser(User user){
	System.out.println("-------addUser--------");
		
		System.out.println(user.getName());
		
		return "home";
	}
	
	@RequestMapping("/list")
	public String listUser(){
		return "home";
	}
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable("id") int id){
		
		System.out.println("-------deleteUser--------"+id);
		
		/**
		 * 同步更新，这里主要指基于RequestMethod.DELETE和RequestMethod.PUT的更新操作，
		 * 更新完成过后需要重定向。
		 * 如果是异步更新，没有转发操作，因此也就不存在该问题。
		 * */
		return "redirect:/rest/list";
	}
	//异步删除
	/*@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteUser(@PathVariable("id") int id){
		
		System.out.println("-------deleteUser--------"+id);
		
		return "hello";
	}*/
	
	@RequestMapping(value="/user",method=RequestMethod.PUT)
	public String updateUser(User user){
		System.out.println("----update-----");
		System.out.println(user);
		return "redirect:/rest/user/1";
	}
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public String findUser(@PathVariable("id") int id){
		
		System.out.println("-------findUser--------"+id);
		
		return "home";
	}
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String findAllUser(){
		
		System.out.println("-------findAllUser--------");
		
		return "home";
	}

}
