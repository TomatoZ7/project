package com.apeces.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apeces.dao.OrderDao;
import com.apeces.domain.Order;

@Component
public class OrderDaoImpl implements OrderDao {
	@Autowired
    SqlSessionTemplate ssTemplate;

	@Override
	public double count() {
		return ssTemplate.getMapper(OrderDao.class).count();
	}

	@Override
	public List<List<?>> queryOrderByShop(Map<String, Object> param){
		return ssTemplate.getMapper(OrderDao.class).queryOrderByShop(param);
	}

	@Override
	public Order queryOrder(int id) {
		return ssTemplate.getMapper(OrderDao.class).queryOrder(id);
	}
}
