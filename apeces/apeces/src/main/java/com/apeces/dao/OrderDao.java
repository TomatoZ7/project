package com.apeces.dao;

import java.util.List;
import java.util.Map;

import com.apeces.domain.Order;
import com.apeces.pojo.AppOrder;

public interface OrderDao {
	String count(Map<String, Object> param);
	
	List<List<?>> queryOrderByShop(Map<String, Object> param);
	
	Order queryOrder(int id);
	
	
	int genOrder(Order order);
	
	int payOrder(int id);
	
	List<List<?>> queryAppOrderByUser(Map<String, Object> param);
	
	AppOrder queryAppOrder(int id);
	
	int remind(int id);
	
	int refund(Map<String, Object> param);
}
