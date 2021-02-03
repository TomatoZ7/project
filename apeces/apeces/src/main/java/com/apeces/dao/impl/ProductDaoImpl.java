package com.apeces.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apeces.dao.ProductDao;
import com.apeces.domain.Product;
import com.apeces.pojo.AppProDetail;
import com.apeces.pojo.ProCatePivot;

@Component
public class ProductDaoImpl implements ProductDao {
	@Autowired
    SqlSessionTemplate ssTemplate;
	
	@Override
	public List<List<?>> queryProByShop(Map<String, Object> param){
		return ssTemplate.getMapper(ProductDao.class).queryProByShop(param);
	}
	
	@Override
	public ProCatePivot queryPro(int id) {
		return ssTemplate.getMapper(ProductDao.class).queryPro(id);
	}
	
	@Override
	public int insertPro(Product pro) {
		return ssTemplate.getMapper(ProductDao.class).insertPro(pro);
	}
	
	@Override
	public int editPro(Product pro) {
		return ssTemplate.getMapper(ProductDao.class).editPro(pro);
	}
	
	@Override
	public int delPro(int id) {
		return ssTemplate.getMapper(ProductDao.class).delPro(id);
	}
	
	
	@Override
	public List<List<?>> queryAppPro(Map<String, Object> param){
		return ssTemplate.getMapper(ProductDao.class).queryAppPro(param);
	}
	
	@Override
	public AppProDetail queryAppProDetail(int id){
		return ssTemplate.getMapper(ProductDao.class).queryAppProDetail(id);
	}
}
