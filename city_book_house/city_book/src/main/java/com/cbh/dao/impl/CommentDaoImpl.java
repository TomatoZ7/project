package com.cbh.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.cbh.dao.CommentDao;
import com.cbh.domain.Comment;

public class CommentDaoImpl implements CommentDao {
	@Autowired
    SqlSessionTemplate ssTemplate;

	@Override
	public List<List<?>> getCommentList(Map<?,?> param){
		return ssTemplate.getMapper(CommentDao.class).getCommentList(param);
	}
	
	@Override
	public int insertComment(Comment comment) {
		return ssTemplate.getMapper(CommentDao.class).insertComment(comment);
	}
}
