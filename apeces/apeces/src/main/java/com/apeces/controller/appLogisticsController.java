package com.apeces.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apeces.domain.Logistics;
import com.apeces.service.LogisticsService;
import com.apeces.utils.Result;

@RequestMapping(value = "/api/logistics")
@RestController
public class appLogisticsController {
	@Autowired
	LogisticsService logisticsService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result index(@RequestParam Integer order_id) {
		List<Logistics> list = logisticsService.queryLogByOrder(order_id);
		
		if (list == null) {
			return new Result(2000, "暂无物流信息", null);
		}
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("data", list);
		
		return new Result(2000, "成功", res);
	}
}
