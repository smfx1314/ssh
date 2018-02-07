package com.ssh.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.UserDao;
import com.ssh.entity.User;
import com.ssh.service.UserService;

@Transactional
public class UserServiceImpl implements UserService {
	//ע��dao
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	//��¼
	@Override
	public User login(User user) {
		
		return userDao.login(user);
	}
}
