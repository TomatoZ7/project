package com.cbh.service;

import java.util.List;
import java.util.Map;

import com.cbh.domain.UserApply;

public interface UserApplyService {
	List<List<?>> getUserApplyList(Map<?,?> param);
	
	int verifyUserApply(Map<?,?> param);
	
	
	/******  �ƶ���  *******/
	int insertUserApply(UserApply userApply);
}
