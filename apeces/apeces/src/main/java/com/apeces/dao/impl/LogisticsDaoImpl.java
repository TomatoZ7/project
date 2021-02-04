package com.apeces.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apeces.dao.LogisticsDao;
import com.apeces.domain.Logistics;

@Component
public class LogisticsDaoImpl implements LogisticsDao {
	@Autowired
    SqlSessionTemplate ssTemplate;

	@Override
	public int genLog(List<?> list){
		return ssTemplate.getMapper(LogisticsDao.class).genLog(list);
	}

	@Override
	public List<Logistics> queryLogByOrder(int order_id){
		return ssTemplate.getMapper(LogisticsDao.class).queryLogByOrder(order_id);
	}
}
