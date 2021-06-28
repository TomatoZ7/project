package com.cbh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbh.dao.UserApplyDao;
import com.cbh.domain.UserApply;
import com.cbh.service.UserApplyService;

@Service
public class UserApplyServiceImpl implements UserApplyService {
	@Autowired
	UserApplyDao userApplyDao;
	
	@Override
	public List<List<?>> getUserApplyList(Map<?,?> param) {
		return userApplyDao.getUserApplyList(param);
	}
	
	@Override
	public int verifyUserApply(Map<?,?> param) {
		return userApplyDao.verifyUserApply(param);
	}
	
	
	/******  ÒÆ¶¯¶Ë  *******/
	@Override
	public int insertUserApply(UserApply userApply) {
		return userApplyDao.insertUserApply(userApply);
	}
}
