package com.apeces.service;

import java.util.List;
import java.util.Map;

import com.apeces.domain.Product;
import com.apeces.pojo.ProCatePivot;

public interface ProductService {
	List<List<?>> queryProByShop(Map<String, Object> param);
	
	ProCatePivot queryPro(int id);
	
	int insertPro(Product pro);
	
	int editPro(Product pro);
	
	int delPro(int id);
}
