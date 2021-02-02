package com.apeces.service;

import java.util.List;
import java.util.Map;

import com.apeces.domain.Order;

public interface OrderService {
	double count();
	
	List<List<?>> queryOrderByShop(Map<String, Object> param);
	
	Order queryOrder(int id);
}
