package com.apeces.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apeces.dao.NewsDao;
import com.apeces.domain.News;
import com.apeces.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {
	@Autowired
	NewsDao newsDao;
	
	@Override
	public List<List<?>> queryNewsByShop(Map<String, Object> param){
		return newsDao.queryNewsByShop(param);
	}
	
	@Override
	public News queryNews(int id){
		return newsDao.queryNews(id);
	}
	
	@Override
	public int insertNews(News news){
		return newsDao.insertNews(news);
	}
	
	@Override
	public int editNews(News news){
		return newsDao.editNews(news);
	}
	
	@Override
	public int delNews(int id){
		return newsDao.delNews(id);
	}

	
	@Override
	public List<List<?>> queryAppNews(Map<String, Object> param){
		return newsDao.queryAppNews(param);
	}
	
	@Override
	public News queryAppNew(int id){
		return newsDao.queryAppNew(id);
	}
}
