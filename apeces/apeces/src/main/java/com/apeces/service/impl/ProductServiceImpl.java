package com.apeces.service.impl;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apeces.dao.ProductDao;
import com.apeces.domain.Product;
import com.apeces.pojo.AppProDetail;
import com.apeces.pojo.ProCatePivot;
import com.apeces.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;
	
	@Override
	public List<List<?>> queryProByShop(Map<String, Object> param){
		return productDao.queryProByShop(param);
	}
	
	@Override
	public ProCatePivot queryPro(int id) {
		return productDao.queryPro(id);
	}
	
	@Override
	public int insertPro(Product pro) {
		return productDao.insertPro(pro);
	}
	
	@Override
	public int editPro(Product pro) {
		return productDao.editPro(pro);
	}
	
	@Override
	public int delPro(int id) {
		return productDao.delPro(id);
	}
	
	
	@Override
	public List<List<?>> queryAppPro(Map<String, Object> param){
		return productDao.queryAppPro(param);
	}
	
	@Override
	public AppProDetail queryAppProDetail(int id) {
		return productDao.queryAppProDetail(id);
	}
	
	@Override
	public int updateNums(Map<String, Object> param) {
		return productDao.updateNums(param);
	}
}
