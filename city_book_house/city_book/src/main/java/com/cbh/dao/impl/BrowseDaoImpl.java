package com.cbh.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.cbh.dao.BrowseDao;
import com.cbh.domain.Browse;

public class BrowseDaoImpl implements BrowseDao {
	@Autowired
    SqlSessionTemplate ssTemplate;
	
	@Override
	public List<Browse> getBrowseList(int user_id){
		return ssTemplate.getMapper(BrowseDao.class).getBrowseList(user_id);
	}
	
	@Override
	public int insertBrowse(Browse browse) {
		return ssTemplate.getMapper(BrowseDao.class).insertBrowse(browse);
	}
}
