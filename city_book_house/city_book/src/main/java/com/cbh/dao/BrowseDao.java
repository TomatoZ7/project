package com.cbh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cbh.domain.Browse;

public interface BrowseDao {
	List<Browse> getBrowseList(@Param("user_id") int user_id);
	
	int insertBrowse(Browse browse);
}
