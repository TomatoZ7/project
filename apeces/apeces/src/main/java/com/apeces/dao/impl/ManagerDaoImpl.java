package com.apeces.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apeces.domain.Manager;
import com.apeces.dao.ManagerDao;

@Component
public class ManagerDaoImpl implements ManagerDao {
	@Autowired
    SqlSessionTemplate ssTemplate;

	@Override
	public Manager login(Manager manager) {
		return ssTemplate.getMapper(ManagerDao.class).login(manager);
	}

	@Override
	public List<List<?>> queryManager(Map<String, Object> param){
		return ssTemplate.getMapper(ManagerDao.class).queryManager(param);
	}

	@Override
	public Manager queryManagerSingle(int id) {
		return ssTemplate.getMapper(ManagerDao.class).queryManagerSingle(id);
	}

	@Override
	public int insertManager(Manager manager) {
		return ssTemplate.getMapper(ManagerDao.class).insertManager(manager);
	}

	@Override
	public int delManager(int id) {
		return ssTemplate.getMapper(ManagerDao.class).delManager(id);
	}
}
