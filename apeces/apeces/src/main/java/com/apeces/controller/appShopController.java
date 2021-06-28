package com.apeces.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apeces.service.ShopService;
import com.apeces.utils.Result;

@RequestMapping(value = "/api/shop")
@RestController
public class appShopController {
	@Autowired
	ShopService shopService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result list(@RequestParam Integer offset, @RequestParam Integer limit) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("limit", limit);
		params.put("offset", offset);
		
		List<List<?>> list = shopService.queryAppShopList(params);
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("total", list.get(1).get(0));
		res.put("data", list.get(0));
		
		return new Result(2000, "³É¹¦", res);
	}
}
