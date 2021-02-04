package com.apeces.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apeces.dao.CommentDao;
import com.apeces.domain.Comment;
import com.apeces.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDao commentDao;
	
	@Override
	public List<List<?>> queryCommByShop(Map<String, Object> param){
		return commentDao.queryCommByShop(param);
	}
	
	@Override
	public int delComm(int id) {
		return commentDao.delComm(id);
	}
	
	
	
	@Override
	public List<List<?>> queryAppComm(Map<String, Object> param) {
		return commentDao.queryAppComm(param);
	}
	
	@Override
	public int insertComm(Comment comment) {
		return commentDao.insertComm(comment);
	}
}
