package com.apeces.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apeces.dao.UserDao;
import com.apeces.domain.User;
import com.apeces.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	
	@Override
	public int register(User user) {
		return userDao.register(user);
	}
	
	@Override
	public User login(User user) {
		return userDao.login(user);
	}
}
