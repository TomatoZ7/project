package com.apeces.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apeces.dao.CategoryDao;
import com.apeces.domain.Category;

@Component
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
    SqlSessionTemplate ssTemplate;

	@Override
	public List<List<?>> queryCate(Map<String, Object> param){
		return ssTemplate.getMapper(CategoryDao.class).queryCate(param);
	}
	
	@Override
	public Category queryCateSingle(int id) {
		return ssTemplate.getMapper(CategoryDao.class).queryCateSingle(id);
	}

	@Override
	public int insertCate(Category category) {
		return ssTemplate.getMapper(CategoryDao.class).insertCate(category);
	}

	@Override
	public int editCate(Category category) {
		return ssTemplate.getMapper(CategoryDao.class).editCate(category);
	}

	@Override
	public int delCate(int id) {
		return ssTemplate.getMapper(CategoryDao.class).delCate(id);
	}
}
