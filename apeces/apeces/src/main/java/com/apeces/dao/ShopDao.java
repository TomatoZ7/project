package com.apeces.dao;

import com.apeces.domain.Shop;

public interface ShopDao {
	Shop queryShop(int id);
	
	int insertShop(Shop shop);
	
	int updateShop(Shop shop);
}
