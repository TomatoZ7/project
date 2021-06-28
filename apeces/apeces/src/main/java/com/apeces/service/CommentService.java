package com.apeces.service;

import java.util.List;
import java.util.Map;

import com.apeces.domain.Comment;

public interface CommentService {
	List<List<?>> queryCommByShop(Map<String, Object> param);
	
	int delComm(int id);
	
	
	List<List<?>> queryAppComm(Map<String, Object> param);
	
	int insertComm(Comment comment);
}
