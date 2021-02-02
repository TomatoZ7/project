package com.apeces.service;

import java.util.List;
import java.util.Map;

public interface CommentService {
	List<List<?>> queryCommByShop(Map<String, Object> param);
	
	int delComm(int id);
}
