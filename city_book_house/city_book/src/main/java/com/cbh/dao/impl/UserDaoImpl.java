package com.cbh.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbh.dao.UserDao;
import com.cbh.domain.User;
import com.cbh.pojo.UserCenter;

@Component
public class UserDaoImpl implements UserDao {
	@Autowired
    SqlSessionTemplate ssTemplate;
	
	@Override
	public List<List<?>> getUserList(Map<?,?> param){
		return ssTemplate.getMapper(UserDao.class).getUserList(param);
	}
	
	@Override
	public User getUserById(int id) {
		return ssTemplate.getMapper(UserDao.class).getUserById(id);
	}
	
	@Override
	public User recheckUser(User user) {
		return ssTemplate.getMapper(UserDao.class).recheckUser(user);
	}
	
	@Override
	public int insertUser(User user) {
		return ssTemplate.getMapper(UserDao.class).insertUser(user);
	}
	
	@Override
	public int updateUser(User user) {
		return ssTemplate.getMapper(UserDao.class).updateUser(user);
	}
	
	@Override
	public int verifyUser(Map<?,?> param) {
		return ssTemplate.getMapper(UserDao.class).verifyUser(param);
	}
	
	@Override
	public int updateUserBatch(Map<?,?> param) {
		return ssTemplate.getMapper(UserDao.class).updateUserBatch(param);
	}
	
	@Override
	public int countUser() {
		return ssTemplate.getMapper(UserDao.class).countUser();
	}
	
	
	/******  ÒÆ¶¯¶Ë  *******/
	
	@Override
	public User getUserByLogin(User user) {
		return ssTemplate.getMapper(UserDao.class).getUserByLogin(user);
	}
	
	@Override
	public int register(User user) {
		return ssTemplate.getMapper(UserDao.class).register(user);
	}
	
	@Override
	public int resetPwd(Map<?,?> param) {
		return ssTemplate.getMapper(UserDao.class).resetPwd(param);
	}
	
	@Override
	public int apiUpdateUser(User user) {
		return ssTemplate.getMapper(UserDao.class).apiUpdateUser(user);
	}
	
	@Override
	public UserCenter getUserWithBalance(int id) {
		return ssTemplate.getMapper(UserDao.class).getUserWithBalance(id);
	}
}
