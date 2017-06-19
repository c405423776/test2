package com.bwfspring.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwfspring.test.dao.IUserDao;
import com.bwfspring.test.domain.User;
@Service("userServiceImpl")
public class UserServiceImpl implements IUserService{
	/**
	 * UserServiceImpl��������userDao������
	 * service�����dao�����ʵ����������Spring IOC��������ɵ�.
	 * ����ע��������MyBatis����Ŀ�У�dao�����ʵ�����Ƕ�̬�������ġ����Ǵ�������dao�����Ȼ��Spring IOC����������
	 * 
	 * @Autowiredע���ʾSpring IOC��������������һ��������IUserDao��Bean����ע��������ԡ�
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
