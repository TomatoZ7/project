package com.cbh.service;

import java.util.List;
import java.util.Map;

import com.cbh.domain.Collect;

public interface CollectService {
	List<Collect> getCollectList(int user_id);
	
	int insertCollect(Collect collect);
	
	int deleteCollect(Map<String, Object> params);
}
