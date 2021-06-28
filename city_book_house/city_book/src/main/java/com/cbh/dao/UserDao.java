package com.cbh.dao;

import java.util.List;
import java.util.Map;

import com.cbh.domain.User;
import com.cbh.pojo.UserCenter;

public interface UserDao {
	List<List<?>> getUserList(Map<?,?> param);
	
	User getUserById(int id);
	
	User recheckUser(User user);
	
	int insertUser(User user);
	
	int updateUser(User user);
	
	int verifyUser(Map<?,?> param);
	
	int updateUserBatch(Map<?,?> param);
	
	int countUser();
	
	
	/******  ÒÆ¶¯¶Ë  *******/
	User getUserByLogin(User user);
	
	int register(User user);
	
	int resetPwd(Map<?,?> param);
	
	int apiUpdateUser(User user);
	
	UserCenter getUserWithBalance(int id);
}
