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
 * @Controller注解用于标识该类是一个控制器.将受SpringMvc容器管理.
 * @RequestMapping用于映射请求路径.
 * @RequestMapping参数详解：
 * 		value:定义处理类/方法的请求的 URL地址    (重点、常用)
 * 		method:定义处理方法的 http method 类型，如 GET、POST 等  (重点、常用)
 * 		params:定义请求的 URL 中必须包含的参数。或者不包含某些参数。(了解)   
 * 				比如：
 * 					@RequestMapping(value = "/find", params = "target")。标识必须包含target参数才能执行该方法.
 * 					@RequestMapping(value = "/find", params = "!target")。标识必须不包含target参数才能执行该方法.
 * 					@RequestMapping(value = "/find", params = "target=111")。标识必须包含target参数并且该参数值为111才能执行该方法.
 * 					@RequestMapping(value = "/find", params = "target!=111")。标识必须包含target参数并且该参数值不等于111才能执行该方法.
 * 		headers:定义请求中 Request Headers 必须包含的参数。或者不包含某些参数  (了解)
 * 				比如：
 * 					@RequestMapping(value = "/specify", headers = "accept=text/*")。标识请求的 Request Headers(请求消息头) 中 Accept 的值必须匹配 text/* ( 如 text/html )，方法才会被调用。
 * *//*
@Controller
@RequestMapping("/user")
public class UserTest01 {
	@Autowired
	private IUserService userService;
	
	*//**
	 * 用户登录
	 * @RequestParam用于匹配请求参数。
	 * 		名称为username的请求参数将赋值给login()方法的username参数。
	 * 		名称为password的请求参数将赋值给login()方法的password参数。
	 * http://localhost:8080/springmvcdemo01/user/login
	 * *//*
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(@RequestParam(value="username",required=true) String username,@RequestParam(value="password",required=true) String password){
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		
		//返回视图名称为home
		return "home";
	}
	
	*//**
	 * 用户注册
	 * 请求参数是POJO类型参数
	 * *//*
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String regist(User user){
		
		System.out.println(user);
		
		userService.addUser(user);
		
		return "home";
	}
	
	*//**
	 * Ant风格的URL:
	 * 		?   匹配一个任意字符          /a/?b -->  可以匹配/a/ab;/a/cb。但不能匹配/a/acb之类
	 * 		*   匹配任意长度的字符    /a/ *b -->  可以匹配/a/cb;/a/acb。但不能匹配/a/cb/vb
	 * 		**  匹配多层路径               可以匹配/a/ab;/a/acb;/a/ab/abc/…/…
	 * *//*
	//@RequestMapping(value="/?")
	//@RequestMapping(value="/*")
	@RequestMapping(value="/**")
	public String testAnt(){
		
		System.out.println("----------testAnt()--------");
		
		return "home";
	}
	
	
	*//**
	 * 使用@PathVariable匹配请求参数
	 * *//*
	@RequestMapping(value="/abc/{name}/{id}")
	public String testPathVariable(@PathVariable("name") String name,@PathVariable("id") Integer id){
		
		System.out.println(id+"\t"+name);
		
		return "home";
	}
	
	
	*//**
	 * 处理异步请求   返回text
	 * *//*
	@RequestMapping("/testjsontext")
	@ResponseBody
	public String testJsonReturnText(){
		
		return "sichuan province";
	}
	
	*//**
	 * 处理异步请求   返回json
	 * *//*
	@RequestMapping("/testjsonuser")
	@ResponseBody
	public com.bwfspring.test.domain.User testJsonReturnJSonUser(){
		
		return new com.bwfspring.test.domain.User("aaaaa", "123", 11, "f");
	}
	
	
	*//**
	 * 返回json数组
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
	 * 处理异步请求   返回xml
	 * *//*
	*//**
	 * 在导入了jackson-dataformat-xml组件的情况下，SpringMVC会优先采用XML格式返回数据;
	 * 如果要想以json格式返回，就需要显示指定produces的值为application/json;charset=UTF-8,这样设置过后SpringMVC就知道返回JSON格式给数据。
	 * *//*
	@GetMapping(value="/finduser",produces={"application/json;charset=UTF-8"})
	@GetMapping(value="/finduser",produces={"application/xml;charset=UTF-8"})
	@ResponseBody
	public User findUser(){
		
		User user=new User("aaaaa", "123", 11, "f");
		
		return user;
	}
	
	
	*//**
	 * 使用Model或者Map存放响应数据。
	 * Model或Map将和视图一起被封装为ModelAndView。
	 * 响应数据归根结底是存放在request请求域中。
	 * 大家可以思考一下为什么要存放在请求域中，而不是会话域中?
	 * 请求域究竟可以存放多少数据?
	 * 服务端渲染视图  生成HTML 响应给客户端  request是服务端对象  存在服务端内存中  请求对象中存放的数据理论上取决于服务端内存空间。
	 * 当然，为了提高响应速度，一般一个HTML不建议承载过多的数据。
	 * *//*
	@RequestMapping("/testmap")
	public String testMap(Map<String, Object> map){
		
		//可以在JSP视图中使用EL表达式在requestScope遍历出该数据。
		map.put("school", "51code");
		
		return "home";
	}

	
	
	*//**
	 * 通过ModelAndView封装响应数据和视图
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