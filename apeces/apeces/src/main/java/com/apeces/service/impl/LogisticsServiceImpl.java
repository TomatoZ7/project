package com.apeces.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apeces.dao.LogisticsDao;
import com.apeces.domain.Logistics;
import com.apeces.service.LogisticsService;

@Service
public class LogisticsServiceImpl implements LogisticsService {
	@Autowired
	LogisticsDao logisticsDao;
	
	@Override
	public int genLog(List<?> list){
		return logisticsDao.genLog(list);
	}

	@Override
	public List<Logistics> queryLogByOrder(int order_id){
		return logisticsDao.queryLogByOrder(order_id);
	}
}
