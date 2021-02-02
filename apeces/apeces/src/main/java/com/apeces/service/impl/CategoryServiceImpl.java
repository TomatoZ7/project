package com.apeces.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apeces.dao.CategoryDao;
import com.apeces.domain.Category;
import com.apeces.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao categoryDao;
	
	@Override
	public List<List<?>> queryCate(Map<String, Object> param){
		return categoryDao.queryCate(param);
	}
	
	@Override
	public Category queryCateSingle(int id) {
		return categoryDao.queryCateSingle(id);
	}

	@Override
	public int insertCate(Category category) {
		return categoryDao.insertCate(category);
	}

	@Override
	public int editCate(Category category) {
		return categoryDao.editCate(category);
	}

	@Override
	public int delCate(int id) {
		return categoryDao.delCate(id);
	}
}
