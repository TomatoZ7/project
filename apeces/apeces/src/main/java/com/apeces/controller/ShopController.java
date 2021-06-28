package com.apeces.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apeces.domain.Shop;
import com.apeces.service.ShopService;
import com.apeces.utils.Result;

@RequestMapping(value = "/admin/shop")
@RestController
public class ShopController {
	@Autowired
	ShopService shopService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result single(@PathVariable Integer id) {
		Shop shop = shopService.queryShop(id);
		
		if (shop == null) {
			return new Result(4004, "未找到", null);
		}
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("id", shop.getId());
		res.put("logo", shop.getLogo());
		res.put("name", shop.getName());
		res.put("phone", shop.getPhone());
		res.put("introduction", shop.getIntroduction());
		
		return new Result(2000, "成功", res);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Result update(@PathVariable Integer id, @RequestBody Shop shop) {
		shop.setId(id);
		int result = shopService.updateShop(shop);
        if (result == 0) {
        	return new Result(5000, "失败。", null);
        }

        return new Result(2000, "成功。", null);
	}
}
