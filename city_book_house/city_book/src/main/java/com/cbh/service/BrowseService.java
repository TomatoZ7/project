package com.cbh.service;

import java.util.List;

import com.cbh.domain.Browse;

public interface BrowseService {
	List<Browse> getBrowseList(int user_id);
	
	int insertBrowse(Browse browse);
}
