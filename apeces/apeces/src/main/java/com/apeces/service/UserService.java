package com.apeces.service;

import com.apeces.domain.User;

public interface UserService {
	int register(User user);
	
	User login(User user);
}
