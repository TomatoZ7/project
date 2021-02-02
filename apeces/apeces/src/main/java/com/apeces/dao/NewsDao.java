package com.apeces.dao;

import java.util.List;
import java.util.Map;

import com.apeces.domain.News;

public interface NewsDao {
	List<List<?>> queryNewsByShop(Map<String, Object> param);
	
	News queryNews(int id);
	
	int insertNews(News news);
	
	int editNews(News news);
	
	int delNews(int id);
}
