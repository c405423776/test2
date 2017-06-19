package com.bwfspring.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwfspring.test.dao.IUserDao;
import com.bwfspring.test.domain.User;
@Service("userServiceImpl")
public class UserServiceImpl implements IUserService{
	/**
	 * UserServiceImpl主键依赖userDao这个组件
	 * service组件和dao组件的实例化都是由Spring IOC容器来完成的.
	 * 【备注：在整合MyBatis的项目中，dao组件的实例化是动态代理创建的。但是创建过后，dao组件依然受Spring IOC容器管理。】
	 * 
	 * @Autowired注解表示Spring IOC容器在容器中找一个类型是IUserDao的Bean对象注入给该属性。
	 * */
	@Autowired
	private IUserDao userDao;
	@Override
	public void addUser(User user) {
		userDao.addUser(user.getName(), user.getPassword(), user.getAge(), user.getSex());
	
	}
	public IUserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
}
