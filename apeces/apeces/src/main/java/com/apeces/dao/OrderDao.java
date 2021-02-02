package com.apeces.dao;

import java.util.List;
import java.util.Map;

import com.apeces.domain.Order;

public interface OrderDao {
	double count();
	
	List<List<?>> queryOrderByShop(Map<String, Object> param);
	
	Order queryOrder(int id);
}
