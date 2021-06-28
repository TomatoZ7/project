package com.apeces.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.apeces.dao.UserDao;
import com.apeces.domain.User;

public class UserDaoImpl implements UserDao {
	@Autowired
    SqlSessionTemplate ssTemplate;
	
	@Override
	public int register(User user) {
		return ssTemplate.getMapper(UserDao.class).register(user);
	}
	
	@Override
	public User login(User user) {
		return ssTemplate.getMapper(UserDao.class).login(user);
	}
}
