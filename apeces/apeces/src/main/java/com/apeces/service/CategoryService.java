package com.apeces.service;

import java.util.List;
import java.util.Map;

import com.apeces.domain.Category;

public interface CategoryService {
	List<List<?>> queryCate(Map<String, Object> param);
	
	Category queryCateSingle(int id);
	
	int insertCate(Category category);
	
	int editCate(Category category);
	
	int delCate(int id);
}
