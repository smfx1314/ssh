package com.ssh.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.UserDao;
import com.ssh.entity.User;
import com.ssh.service.UserService;

@Transactional
public class UserServiceImpl implements UserService {
	//×¢Èëdao
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	//µÇÂ¼
	@Override
	public User login(User user) {
		
		return userDao.login(user);
	}
}
