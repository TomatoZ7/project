package com.cbh.service;

import java.util.List;
import java.util.Map;

import com.cbh.domain.Comment;

public interface CommentService {
	List<List<?>> getCommentList(Map<?,?> param);
	
	int insertComment(Comment comment);
}
