package com.cbh.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbh.dao.BorrowCarDao;
import com.cbh.domain.BorrowCar;

@Component
public class BorrowCarDaoImpl implements BorrowCarDao {
	@Autowired
    SqlSessionTemplate ssTemplate;
	
	@Override
	public List<BorrowCar> getBorrowCarList(Map<?,?> param) {
		// TODO Auto-generated method stub
		return ssTemplate.getMapper(BorrowCarDao.class).getBorrowCarList(param);
	}
	
	@Override
	public int insertSingle(Map<?,?> param) {
		return ssTemplate.getMapper(BorrowCarDao.class).insertSingle(param);
	}
	
	@Override
	public int deleteById(int id) {
		return ssTemplate.getMapper(BorrowCarDao.class).deleteById(id);
	}
	
	@Override
	public int deleteM(Map<?,?> param) {
		return ssTemplate.getMapper(BorrowCarDao.class).deleteM(param);
	}
}
