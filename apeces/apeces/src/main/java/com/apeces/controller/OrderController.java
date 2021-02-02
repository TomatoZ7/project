package com.apeces.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apeces.domain.Order;
import com.apeces.service.OrderService;
import com.apeces.utils.Result;

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
	public void count() {
		// TODO 获取最近四个季度的数据
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result index(int shop_id, int offset, int limit) {
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
	public Result single(@PathVariable int id) {
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
