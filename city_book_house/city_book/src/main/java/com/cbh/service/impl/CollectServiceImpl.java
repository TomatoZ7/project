package com.cbh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbh.dao.CollectDao;
import com.cbh.domain.Collect;
import com.cbh.service.CollectService;

@Service
public class CollectServiceImpl implements CollectService {
	@Autowired
	CollectDao collectDao;
	
	@Override
	public List<Collect> getCollectList(int user_id){
		return collectDao.getCollectList(user_id);
	}
	
	@Override
	public int insertCollect(Collect collect) {
		return collectDao.insertCollect(collect);
	}
	
	@Override
	public int deleteCollect(int id) {
		return collectDao.deleteCollect(id);
	}
}
