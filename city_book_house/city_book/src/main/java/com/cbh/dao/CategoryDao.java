package com.cbh.dao;

import java.util.List;
import java.util.Map;

import com.cbh.domain.Category;
import com.cbh.pojo.firstCategory;

public interface CategoryDao {
	List<List<?>> getCategoryList(Map<?,?> param);
	
	Category getCategoryById(int id);
	
	int insertCategory(Category category);
	
	Category getCategoryByName(String category_name);
	
	int updateCategory(Category category);
	
	int delCategoryById(int id);
	
	List<List<?>> getCategoryWithLevel();
	
	int countCategory();
	
	int insertExcCate(firstCategory firstCate);
	
	
	/******  ÒÆ¶¯¶Ë  *******/
	List<Category> getIndexCategory();
	
	List<firstCategory> getCategory();
}
