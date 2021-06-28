package com.cbh.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.cbh.dao.UserApplyDao;
import com.cbh.domain.UserApply;

public class UserApplyDaoImpl implements UserApplyDao {
	@Autowired
    SqlSessionTemplate ssTemplate;
	
	@Override
	public List<List<?>> getUserApplyList(Map<?,?> param){
		return ssTemplate.getMapper(UserApplyDao.class).getUserApplyList(param);
	}
	
	@Override
	public int verifyUserApply(Map<?,?> param) {
		return ssTemplate.getMapper(UserApplyDao.class).verifyUserApply(param);
	}
	
	
	/******  ÒÆ¶¯¶Ë  *******/
	@Override
	public int insertUserApply(UserApply userApply) {
		return ssTemplate.getMapper(UserApplyDao.class).insertUserApply(userApply);
	}
}
