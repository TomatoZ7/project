package com.cbh.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbh.dao.CategoryDao;
import com.cbh.domain.Category;
import com.cbh.pojo.firstCategory;

@Component
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
    SqlSessionTemplate ssTemplate;

	@Override
	public List<List<?>> getCategoryList(Map<?,?> param) {
		// TODO Auto-generated method stub
		return ssTemplate.getMapper(CategoryDao.class).getCategoryList(param);
	}
	
	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return ssTemplate.getMapper(CategoryDao.class).getCategoryById(id);
	}
	
	@Override
	public int insertCategory(Category category) {
		return ssTemplate.getMapper(CategoryDao.class).insertCategory(category);
	}
	
	@Override
	public Category getCategoryByName(String category_name) {
		return ssTemplate.getMapper(CategoryDao.class).getCategoryByName(category_name);
	}
	
	@Override
	public int updateCategory(Category category) {
		return ssTemplate.getMapper(CategoryDao.class).updateCategory(category);
	}
	
	@Override
	public int delCategoryById(int id) {
		return ssTemplate.getMapper(CategoryDao.class).delCategoryById(id);
	}
	
	@Override
	public List<List<?>> getCategoryWithLevel(){
		return ssTemplate.getMapper(CategoryDao.class).getCategoryWithLevel();
	}
	
	@Override
	public int countCategory() {
		return ssTemplate.getMapper(CategoryDao.class).countCategory();
	}
	
	@Override
	public int insertExcCate(firstCategory firstCate) {
		return ssTemplate.getMapper(CategoryDao.class).insertExcCate(firstCate);
	}
	
	
	/******  ÒÆ¶¯¶Ë  *******/
	@Override
	public List<Category> getIndexCategory(){
		return ssTemplate.getMapper(CategoryDao.class).getIndexCategory();
	}
	
	@Override
	public List<firstCategory> getCategory(){
		return ssTemplate.getMapper(CategoryDao.class).getCategory();
	}
}
