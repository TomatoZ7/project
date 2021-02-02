package com.apeces.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apeces.dao.OrderDao;
import com.apeces.domain.Order;
import com.apeces.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
    OrderDao orderDao;
	
	@Override
	public double count() {
		return orderDao.count();
	}
	
	@Override
	public List<List<?>> queryOrderByShop(Map<String, Object> param){
		return orderDao.queryOrderByShop(param);
	}
	
	@Override
	public Order queryOrder(int id) {
		return orderDao.queryOrder(id);
	}
}
