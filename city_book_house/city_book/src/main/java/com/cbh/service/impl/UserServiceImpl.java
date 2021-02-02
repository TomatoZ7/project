package com.cbh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbh.dao.UserDao;
import com.cbh.domain.User;
import com.cbh.pojo.UserCenter;
import com.cbh.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;
	
	@Override
	public List<List<?>> getUserList(Map<?,?> param) {
		return userDao.getUserList(param);
	}
	
	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
	
	@Override
	public User recheckUser(User user) {
		return userDao.recheckUser(user);
	}
	
	@Override
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}
	
	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}
	
	@Override
	public int verifyUser(Map<?,?> param) {
		return userDao.verifyUser(param);
	}
	
	@Override
	public int updateUserBatch(Map<?,?> param) {
		return userDao.updateUserBatch(param);
	}
	
	@Override
	public int countUser() {
		return userDao.countUser();
	}
	
	
	/******  ÒÆ¶¯¶Ë  *******/
	
	@Override
	public User getUserByLogin(User user) {
		return userDao.getUserByLogin(user);
	}
	
	@Override
	public int register(User user) {
		return userDao.register(user);
	}
	
	@Override
	public int resetPwd(Map<?,?> param) {
		return userDao.resetPwd(param);
	}
	
	@Override
	public int apiUpdateUser(User user) {
		return userDao.apiUpdateUser(user);
	}
	
	@Override
	public UserCenter getUserWithBalance(int id) {
		return userDao.getUserWithBalance(id);
	}
}
