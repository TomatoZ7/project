package com.apeces.dao;

import java.util.List;
import java.util.Map;

import com.apeces.domain.Comment;

public interface CommentDao {
	List<List<?>> queryCommByShop(Map<String, Object> param);
	
	int delComm(int id);
	
	
	List<List<?>> queryAppComm(Map<String, Object> param);
	
	int insertComm(Comment comment);
}
