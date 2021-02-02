package com.cbh.dao;

import java.util.List;
import java.util.Map;

import com.cbh.domain.BorrowCar;

public interface BorrowCarDao {
	List<BorrowCar> getBorrowCarList(Map<?,?> param);
	
	int insertSingle(Map<?,?> param);
	
	int deleteById(int id);
	
	int deleteM(Map<?,?> param);
}
