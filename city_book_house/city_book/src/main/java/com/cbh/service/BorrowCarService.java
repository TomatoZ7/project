package com.cbh.service;

import java.util.List;
import java.util.Map;

import com.cbh.domain.BorrowCar;

public interface BorrowCarService {
	List<BorrowCar> getBorrowCarList(Map<?,?> param);
	
	int insertSingle(Map<?,?> param);
	
	int deleteById(int id);
	
	int deleteM(Map<?,?> param);
}
