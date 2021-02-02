package com.cbh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbh.dao.CommentDao;
import com.cbh.domain.Comment;
import com.cbh.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDao commentDao;
	
	@Override
	public List<List<?>> getCommentList(Map<?,?> param){
		return commentDao.getCommentList(param);
	}
	
	@Override
	public int insertComment(Comment comment) {
		return commentDao.insertComment(comment);
	}
}
