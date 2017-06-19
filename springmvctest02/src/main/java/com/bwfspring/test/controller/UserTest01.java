package com.bwfspring.test.controller;
/*package com.bwfspring.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bwfspring.test.service.IUserService;
import com.bwfspring.test.domain.User;

*//**
 * @Controllerע�����ڱ�ʶ������һ��������.����SpringMvc��������.
 * @RequestMapping����ӳ������·��.
 * @RequestMapping������⣺
 * 		value:���崦����/����������� URL��ַ    (�ص㡢����)
 * 		method:���崦������ http method ���ͣ��� GET��POST ��  (�ص㡢����)
 * 		params:��������� URL �б�������Ĳ��������߲�����ĳЩ������(�˽�)   
 * 				���磺
 * 					@RequestMapping(value = "/find", params = "target")����ʶ�������target��������ִ�и÷���.
 * 					@RequestMapping(value = "/find", params = "!target")����ʶ���벻����target��������ִ�и÷���.
 * 					@RequestMapping(value = "/find", params = "target=111")����ʶ�������target�������Ҹò���ֵΪ111����ִ�и÷���.
 * 					@RequestMapping(value = "/find", params = "target!=111")����ʶ�������target�������Ҹò���ֵ������111����ִ�и÷���.
 * 		headers:���������� Request Headers ��������Ĳ��������߲�����ĳЩ����  (�˽�)
 * 				���磺
 * 					@RequestMapping(value = "/specify", headers = "accept=text/*")����ʶ����� Request Headers(������Ϣͷ) �� Accept ��ֵ����ƥ�� text/* ( �� text/html )�������Żᱻ���á�
 * *//*
@Controller
@RequestMapping("/user")
public class UserTest01 {
	@Autowired
	private IUserService userService;
	
	*//**
	 * �û���¼
	 * @RequestParam����ƥ�����������
	 * 		����Ϊusername�������������ֵ��login()������username������
	 * 		����Ϊpassword�������������ֵ��login()������password������
	 * http://localhost:8080/springmvcdemo01/user/login
	 * *//*
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(@RequestParam(value="username",required=true) String username,@RequestParam(value="password",required=true) String password){
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		
		//������ͼ����Ϊhome
		return "home";
	}
	
	*//**
	 * �û�ע��
	 * ���������POJO���Ͳ���
	 * *//*
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String regist(User user){
		
		System.out.println(user);
		
		userService.addUser(user);
		
		return "home";
	}
	
	*//**
	 * Ant����URL:
	 * 		?   ƥ��һ�������ַ�          /a/?b -->  ����ƥ��/a/ab;/a/cb��������ƥ��/a/acb֮��
	 * 		*   ƥ�����ⳤ�ȵ��ַ�    /a/ *b -->  ����ƥ��/a/cb;/a/acb��������ƥ��/a/cb/vb
	 * 		**  ƥ����·��               ����ƥ��/a/ab;/a/acb;/a/ab/abc/��/��
	 * *//*
	//@RequestMapping(value="/?")
	//@RequestMapping(value="/*")
	@RequestMapping(value="/**")
	public String testAnt(){
		
		System.out.println("----------testAnt()--------");
		
		return "home";
	}
	
	
	*//**
	 * ʹ��@PathVariableƥ���������
	 * *//*
	@RequestMapping(value="/abc/{name}/{id}")
	public String testPathVariable(@PathVariable("name") String name,@PathVariable("id") Integer id){
		
		System.out.println(id+"\t"+name);
		
		return "home";
	}
	
	
	*//**
	 * �����첽����   ����text
	 * *//*
	@RequestMapping("/testjsontext")
	@ResponseBody
	public String testJsonReturnText(){
		
		return "sichuan province";
	}
	
	*//**
	 * �����첽����   ����json
	 * *//*
	@RequestMapping("/testjsonuser")
	@ResponseBody
	public com.bwfspring.test.domain.User testJsonReturnJSonUser(){
		
		return new com.bwfspring.test.domain.User("aaaaa", "123", 11, "f");
	}
	
	
	*//**
	 * ����json����
	 * *//*
	@RequestMapping("/testjsonuserlist")
	@ResponseBody
	public List<User> testJsonReturnJSonUserList(){
		
		User user1=new User("aaaaa", "123", 11, "f");
		User user2=new User("aaaaa", "123", 11, "f");
		
		List<User> list=new ArrayList<User>();
		
		list.add(user1);
		list.add(user2);
		
		return list;
	}
	
	
	*//**
	 * �����첽����   ����xml
	 * *//*
	*//**
	 * �ڵ�����jackson-dataformat-xml���������£�SpringMVC�����Ȳ���XML��ʽ��������;
	 * ���Ҫ����json��ʽ���أ�����Ҫ��ʾָ��produces��ֵΪapplication/json;charset=UTF-8,�������ù���SpringMVC��֪������JSON��ʽ�����ݡ�
	 * *//*
	@GetMapping(value="/finduser",produces={"application/json;charset=UTF-8"})
	@GetMapping(value="/finduser",produces={"application/xml;charset=UTF-8"})
	@ResponseBody
	public User findUser(){
		
		User user=new User("aaaaa", "123", 11, "f");
		
		return user;
	}
	
	
	*//**
	 * ʹ��Model����Map�����Ӧ���ݡ�
	 * Model��Map������ͼһ�𱻷�װΪModelAndView��
	 * ��Ӧ���ݹ������Ǵ����request�������С�
	 * ��ҿ���˼��һ��ΪʲôҪ������������У������ǻỰ����?
	 * �����򾿾����Դ�Ŷ�������?
	 * �������Ⱦ��ͼ  ����HTML ��Ӧ���ͻ���  request�Ƿ���˶���  ���ڷ�����ڴ���  ��������д�ŵ�����������ȡ���ڷ�����ڴ�ռ䡣
	 * ��Ȼ��Ϊ�������Ӧ�ٶȣ�һ��һ��HTML��������ع�������ݡ�
	 * *//*
	@RequestMapping("/testmap")
	public String testMap(Map<String, Object> map){
		
		//������JSP��ͼ��ʹ��EL���ʽ��requestScope�����������ݡ�
		map.put("school", "51code");
		
		return "home";
	}

	
	
	*//**
	 * ͨ��ModelAndView��װ��Ӧ���ݺ���ͼ
	 * *//*
	@RequestMapping("/testmv")
	public ModelAndView testMv(){
		System.out.println("================================");
		ModelAndView mv=new ModelAndView("home");
		
		mv.addObject("province", "sichuan");
		
		return mv;
		
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
*/