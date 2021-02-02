package com.apeces.dao;

import java.util.List;
import java.util.Map;

public interface CommentDao {
	List<List<?>> queryCommByShop(Map<String, Object> param);
	
	int delComm(int id);
}
