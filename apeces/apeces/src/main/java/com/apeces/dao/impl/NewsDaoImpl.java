package com.apeces.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apeces.dao.NewsDao;
import com.apeces.domain.News;

@Component
public class NewsDaoImpl implements NewsDao {
	@Autowired
    SqlSessionTemplate ssTemplate;
	
	@Override
	public List<List<?>> queryNewsByShop(Map<String, Object> param){
		return ssTemplate.getMapper(NewsDao.class).queryNewsByShop(param);
	}
	
	@Override
	public News queryNews(int id){
		return ssTemplate.getMapper(NewsDao.class).queryNews(id);
	}
	
	@Override
	public int insertNews(News news){
		return ssTemplate.getMapper(NewsDao.class).insertNews(news);
	}
	
	@Override
	public int editNews(News news){
		return ssTemplate.getMapper(NewsDao.class).editNews(news);
	}
	
	@Override
	public int delNews(int id){
		return ssTemplate.getMapper(NewsDao.class).delNews(id);
	}

	
	@Override
	public List<List<?>> queryAppNews(Map<String, Object> param){
		return ssTemplate.getMapper(NewsDao.class).queryAppNews(param);
	}
	
	@Override
	public News queryAppNew(int id){
		return ssTemplate.getMapper(NewsDao.class).queryAppNew(id);
	}
}
