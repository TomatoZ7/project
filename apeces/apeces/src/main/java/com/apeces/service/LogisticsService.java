package com.apeces.service;

import java.util.List;

import com.apeces.domain.Logistics;

public interface LogisticsService {
	int genLog(List<?> list);
	
	List<Logistics> queryLogByOrder(int order_id);
}
