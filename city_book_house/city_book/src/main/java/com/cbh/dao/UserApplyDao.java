package com.cbh.dao;

import java.util.List;
import java.util.Map;

import com.cbh.domain.UserApply;

public interface UserApplyDao {
	List<List<?>> getUserApplyList(Map<?,?> param);
	
	int verifyUserApply(Map<?,?> param);
	
	
	/******  �ƶ���  *******/
	int insertUserApply(UserApply userApply);
}
