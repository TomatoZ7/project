package com.apeces.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apeces.domain.Order;
import com.apeces.service.OrderService;
import com.apeces.utils.Result;
import com.apeces.utils.Season;

@RequestMapping(value = "/admin/order")
@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	
	/**
	 * 首页数据
	 * 
	 */
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public Result count(Integer shop_id) {
		if (shop_id == null) {
			shop_id = 0;
		}
		
		Date date = new Date();
		LinkedHashMap<String, Object> res = new LinkedHashMap<String, Object>();
		List<Object> list = new ArrayList<Object>();
		
		for (int i = 0; i < 4; ++i) {
			Date curDate = Season.getBeforQuarterStartDate(date, i);
			Date preDate = Season.getBeforQuarterStartDate(date, i+1);

			String curFormattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(curDate);
			String preFormattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(preDate);

			Map<String, Object> param = new HashMap<String, Object>();
			param.put("start_time", preFormattedDate);
			param.put("end_time", curFormattedDate);
			param.put("shop_id", shop_id);
			String amount = orderService.count(param);
			
			String season = "" + Season.getSeason(preDate);
			
			Map<String, Object> tempMap = new HashMap<String, Object>();
			tempMap.put("key", season);
			tempMap.put("value", amount);
			list.add(tempMap);
		}
		
		res.put("data", list);
		
		return new Result(2000, "成功", res);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result index(Integer shop_id, Integer offset, Integer limit) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("shop_id", shop_id);
		param.put("offset", offset);
		param.put("limit", limit);
		List<List<?>> list = orderService.queryOrderByShop(param);
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("total", list.get(1).get(0));
		res.put("data", list.get(0));
		
		return new Result(2000, "成功", res);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result single(@PathVariable Integer id) {
		Order order = orderService.queryOrder(id);
		
		if (order == null) {
			return new Result(4004, "未找到", null);
		}
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("id", order.getId());
		res.put("order_no", order.getOrder_no());
		res.put("nums", order.getNums());
		res.put("amount", order.getAmount());
		res.put("status", order.getStatus());
		res.put("create_time", order.getCreate_time());
		res.put("product", order.getProduct());
		res.put("address", order.getAddress());
		
		return new Result(2000, "成功", res);
	}
}
