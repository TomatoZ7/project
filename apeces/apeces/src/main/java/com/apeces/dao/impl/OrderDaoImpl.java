package com.apeces.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apeces.dao.OrderDao;
import com.apeces.domain.Order;
import com.apeces.pojo.AppOrder;

@Component
public class OrderDaoImpl implements OrderDao {
	@Autowired
    SqlSessionTemplate ssTemplate;

	@Override
	public String count(Map<String, Object> param) {
		return ssTemplate.getMapper(OrderDao.class).count(param);
	}

	@Override
	public List<List<?>> queryOrderByShop(Map<String, Object> param){
		return ssTemplate.getMapper(OrderDao.class).queryOrderByShop(param);
	}

	@Override
	public Order queryOrder(int id) {
		return ssTemplate.getMapper(OrderDao.class).queryOrder(id);
	}
	
	
	@Override
	public int genOrder(Order order) {
		return ssTemplate.getMapper(OrderDao.class).genOrder(order);
	}
	
	@Override
	public int payOrder(int id) {
		return ssTemplate.getMapper(OrderDao.class).payOrder(id);
	}

	@Override
	public List<List<?>> queryAppOrderByUser(Map<String, Object> param){
		return ssTemplate.getMapper(OrderDao.class).queryAppOrderByUser(param);
	}

	@Override
	public AppOrder queryAppOrder(int id) {
		return ssTemplate.getMapper(OrderDao.class).queryAppOrder(id);
	}

	@Override
	public int remind(int id) {
		return ssTemplate.getMapper(OrderDao.class).remind(id);
	}

	@Override
	public int refund(Map<String, Object> param){
		return ssTemplate.getMapper(OrderDao.class).refund(param);
	}
}
