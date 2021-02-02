package com.apeces.service;

import com.apeces.domain.Shop;

public interface ShopService {
	Shop queryShop(int id);
	
	int insertShop(Shop shop);
	
	int updateShop(Shop shop);
}
