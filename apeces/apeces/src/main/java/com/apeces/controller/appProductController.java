package com.apeces.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apeces.pojo.AppProDetail;
import com.apeces.service.ProductService;
import com.apeces.utils.Result;

@RequestMapping(value = "/api/product")
@RestController
public class appProductController {
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result list(@RequestParam Integer offset, @RequestParam Integer limit, Integer category_id, String content) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("limit", limit);
		params.put("offset", offset);
		params.put("category_id", category_id);
		params.put("content", content);
		
		List<List<?>> list = productService.queryAppPro(params);
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("total", list.get(1).get(0));
		res.put("data", list.get(0));
		
		return new Result(2000, "成功", res);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result single(@PathVariable int id) {
		AppProDetail pro = productService.queryAppProDetail(id);
		if (pro == null) {
			return new Result(4004, "未找到", null);
		}
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("id", pro.getId());
		res.put("price", pro.getPrice());
		res.put("cover_img", pro.getCover_img());
		res.put("unit", pro.getUnit());
		res.put("introduction", pro.getIntroduction());
		res.put("detail_img", pro.getDetail_img());
		res.put("nums", pro.getNums());
		res.put("category_id", pro.getCategory_id());
		res.put("category_name", pro.getCategory_name());
		res.put("shop_id", pro.getShop_id());
		res.put("shop_name", pro.getShop_name());
		res.put("shop_logo", pro.getShop_logo());
		
		return new Result(2000, "成功", res);
	}
}
