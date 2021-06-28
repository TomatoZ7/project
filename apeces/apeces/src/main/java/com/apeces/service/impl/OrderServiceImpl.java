package com.apeces.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apeces.dao.OrderDao;
import com.apeces.domain.Order;
import com.apeces.pojo.AppOrder;
import com.apeces.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
    OrderDao orderDao;
	
	@Override
	public String count(Map<String, Object> param) {
		return orderDao.count(param);
	}
	
	@Override
	public List<List<?>> queryOrderByShop(Map<String, Object> param){
		return orderDao.queryOrderByShop(param);
	}
	
	@Override
	public Order queryOrder(int id) {
		return orderDao.queryOrder(id);
	}
	
	
	@Override
	public int genOrder(Order order) {
		return orderDao.genOrder(order);
	}
	
	@Override
	public int payOrder(int id) {
		return orderDao.payOrder(id);
	}
	
	@Override
	public List<List<?>> queryAppOrderByUser(Map<String, Object> param){
		return orderDao.queryAppOrderByUser(param);
	}

	@Override
	public AppOrder queryAppOrder(int id) {
		return orderDao.queryAppOrder(id);
	}
	
	@Override
	public int remind(int id) {
		return orderDao.remind(id);
	}
	
	@Override
	public int refund(Map<String, Object> param) {
		return orderDao.refund(param);
	}
}
