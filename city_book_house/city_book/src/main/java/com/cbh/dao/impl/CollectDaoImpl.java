package com.cbh.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbh.dao.CollectDao;
import com.cbh.domain.Collect;

@Component
public class CollectDaoImpl implements CollectDao {
	@Autowired
    SqlSessionTemplate ssTemplate;
	
	@Override
	public List<Collect> getCollectList(int user_id){
		return ssTemplate.getMapper(CollectDao.class).getCollectList(user_id);
	}
	
	@Override
	public int insertCollect(Collect collect) {
		return ssTemplate.getMapper(CollectDao.class).insertCollect(collect);
	}
	
	@Override
	public int deleteCollect(int id) {
		return ssTemplate.getMapper(CollectDao.class).deleteCollect(id);
	}
}
