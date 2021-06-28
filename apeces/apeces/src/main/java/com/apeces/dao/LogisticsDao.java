package com.apeces.dao;

import java.util.List;

import com.apeces.domain.Logistics;

public interface LogisticsDao {
	int genLog(List<?> list);
	
	List<Logistics> queryLogByOrder(int order_id);
}
