package com.cbh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbh.dao.BorrowCarDao;
import com.cbh.domain.BorrowCar;
import com.cbh.service.BorrowCarService;

@Service
public class BorrowCarServiceImpl implements BorrowCarService {
	@Autowired
	BorrowCarDao borrowCarDao;
	
	@Override
	public List<BorrowCar> getBorrowCarList(Map<?,?> param){
		return borrowCarDao.getBorrowCarList(param);
	}
	
	@Override
	public int insertSingle(Map<?,?> param) {
		return borrowCarDao.insertSingle(param);
	}
	
	@Override
	public int deleteById(int id) {
		return borrowCarDao.deleteById(id);
	}
	
	@Override
	public int deleteM(Map<?,?> param) {
		return borrowCarDao.deleteM(param);
	}
}
