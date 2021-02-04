package com.apeces.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apeces.dao.CommentDao;
import com.apeces.domain.Comment;

@Component
public class CommentDaoImpl implements CommentDao {
	@Autowired
    SqlSessionTemplate ssTemplate;

	@Override
	public List<List<?>> queryCommByShop(Map<String, Object> param){
		return ssTemplate.getMapper(CommentDao.class).queryCommByShop(param);
	}

	@Override
	public int delComm(int id) {
		return ssTemplate.getMapper(CommentDao.class).delComm(id);
	}
	
	
	
	@Override
	public List<List<?>> queryAppComm(Map<String, Object> param) {
		return ssTemplate.getMapper(CommentDao.class).queryAppComm(param);
	}
	
	@Override
	public int insertComm(Comment comment) {
		return ssTemplate.getMapper(CommentDao.class).insertComm(comment);
	}
}
