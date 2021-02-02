package com.apeces.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apeces.dao.ShopDao;
import com.apeces.domain.Shop;

@Component
public class ShopDaoImpl implements ShopDao {
	@Autowired
    SqlSessionTemplate ssTemplate;
	
	@Override
	public Shop queryShop(int id) {
		return ssTemplate.getMapper(ShopDao.class).queryShop(id);
	}
	
	@Override
	public int insertShop(Shop shop) {
		return ssTemplate.getMapper(ShopDao.class).insertShop(shop);
	}
	
	@Override
	public int updateShop(Shop shop) {
		return ssTemplate.getMapper(ShopDao.class).updateShop(shop);
	}
}
