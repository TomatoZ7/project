package com.cbh.dao;

import java.util.List;
import java.util.Map;

import com.cbh.domain.Comment;

public interface CommentDao {
	List<List<?>> getCommentList(Map<?,?> param);
	
	int insertComment(Comment comment);
}
