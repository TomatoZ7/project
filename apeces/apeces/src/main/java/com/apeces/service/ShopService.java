package com.apeces.service;

import java.util.List;
import java.util.Map;

import com.apeces.domain.Shop;

public interface ShopService {
	Shop queryShop(int id);
	
	int insertShop(Shop shop);
	
	int updateShop(Shop shop);
	
	
	List<List<?>> queryAppShopList(Map<String, Object> param);
}
