package com.apeces.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apeces.service.ManagerService;
import com.apeces.dao.ManagerDao;
import com.apeces.domain.Manager;

@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
    ManagerDao managerDao;
	
	@Override
	public Manager login(Manager manager) {
		return managerDao.login(manager);
	}
	
	@Override
	public List<List<?>> queryManager(Map<String, Object> param) {
		return managerDao.queryManager(param);
	}
	
	@Override
	public Manager queryManagerSingle(int id) {
		return managerDao.queryManagerSingle(id);
	}
	
	@Override
	public int insertManager(Manager manager) {
		return managerDao.insertManager(manager);
	}
	
	@Override
	public int delManager(int id) {
		return managerDao.delManager(id);
	}
}
