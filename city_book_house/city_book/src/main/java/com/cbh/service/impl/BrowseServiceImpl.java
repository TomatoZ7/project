package com.cbh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbh.dao.BrowseDao;
import com.cbh.domain.Browse;
import com.cbh.service.BrowseService;

@Service
public class BrowseServiceImpl implements BrowseService {
	@Autowired
	BrowseDao browseDao;
	
	@Override
	public List<Browse> getBrowseList(int user_id){
		return browseDao.getBrowseList(user_id);
	}
	
	@Override
	public int insertBrowse(Browse browse) {
		return browseDao.insertBrowse(browse);
	}

}
