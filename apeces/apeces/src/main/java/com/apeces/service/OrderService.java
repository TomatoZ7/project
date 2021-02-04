package com.apeces.service;

import java.util.List;
import java.util.Map;

import com.apeces.domain.Order;
import com.apeces.pojo.AppOrder;

public interface OrderService {
	double count();
	
	List<List<?>> queryOrderByShop(Map<String, Object> param);
	
	Order queryOrder(int id);
	
	
	int genOrder(Order order);
	
	int payOrder(int id);
	
	List<List<?>> queryAppOrderByUser(Map<String, Object> param);
	
	AppOrder queryAppOrder(int id);
	
	int remind(int id);
	
	int refund(Map<String, Object> param);
}
