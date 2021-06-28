package com.apeces.service;

import java.util.List;
import java.util.Map;

import com.apeces.domain.Manager;

public interface ManagerService {
	Manager login(Manager manager);
	
	List<List<?>> queryManager(Map<String, Object> param);
	
	Manager queryManagerSingle(int id);
	
	int insertManager(Manager manager);
	
	int delManager(int id);
}
