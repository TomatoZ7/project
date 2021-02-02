package com.apeces.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apeces.dao.ShopDao;
import com.apeces.domain.Shop;
import com.apeces.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
    ShopDao shopDao;
	
	@Override
	public Shop queryShop(int id) {
		return shopDao.queryShop(id);
	}
	
	@Override
	public int insertShop(Shop shop) {
		return shopDao.insertShop(shop);
	}
	
	@Override
	public int updateShop(Shop shop) {
		return shopDao.updateShop(shop);
	}
}
