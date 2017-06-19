package com.bwfspring.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bwfspring.test.domain.User;

/**
 * ֪ʶ�㣺
 * 1������Restful API�ӿ����
 * 2������Spring MVC���Restful API�������CRUD������
 * */
@Controller
@RequestMapping("/rest")
public class UesrTest {

	/**
	 * �������һ��User
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
		 * ͬ�����£�������Ҫָ����RequestMethod.DELETE��RequestMethod.PUT�ĸ��²�����
		 * ������ɹ�����Ҫ�ض���
		 * ������첽���£�û��ת�����������Ҳ�Ͳ����ڸ����⡣
		 * */
		return "redirect:/rest/list";
	}
	//�첽ɾ��
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
