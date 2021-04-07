package com.cbh.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cbh.domain.Collect;

public interface CollectDao {
	List<Collect> getCollectList(@Param("user_id") int user_id);
	
	int insertCollect(Collect collect);
	
	int deleteCollect(Map<String, Object> params);
}
