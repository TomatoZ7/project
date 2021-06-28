package com.cbh.service;

import java.util.List;
import java.util.Map;

import com.cbh.domain.Category;
import com.cbh.pojo.firstCategory;

public interface CategoryService {
	List<List<?>> getCategoryList(Map<?,?> param);
	
	Category getCategoryByid(int id);
	
	int insertCategory(Category category);
	
	Category getCategoryByName(String category_name);
	
	int updateCategory(Category category);
	
	int delCategoryById(int id);
	
	List<List<?>> getCategoryWithLevel();
	
	int countCategory();
	
	int insertExcCate(firstCategory firstCate);
	
	
	/******  �ƶ���  *******/
	List<Category> getIndexCategory();
	
	List<firstCategory> getCategory();
}
