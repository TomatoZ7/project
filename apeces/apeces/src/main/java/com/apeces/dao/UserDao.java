package com.apeces.dao;

import com.apeces.domain.User;

public interface UserDao {
	int register(User user);
	
	User login(User user);
}
