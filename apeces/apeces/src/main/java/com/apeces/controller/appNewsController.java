package com.apeces.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apeces.domain.News;
import com.apeces.service.NewsService;
import com.apeces.utils.Result;

@RequestMapping(value = "/api/news")
@RestController
public class appNewsController {
	@Autowired
	NewsService newsService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result index(Integer shop_id, Integer offset, Integer limit) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("shop_id", shop_id);
		param.put("offset", offset);
		param.put("limit", limit);
		List<List<?>> list = newsService.queryAppNews(param);
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("total", list.get(1).get(0));
		res.put("data", list.get(0));
		
		return new Result(2000, "成功", res);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result single(@PathVariable Integer id) {
		News news = newsService.queryAppNew(id);
		
		if (news == null) {
			return new Result(4004, "未找到", null);
		}
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("id", news.getId());
		res.put("title", news.getTitle());
		res.put("cover_img", news.getCover_img());
		res.put("content", news.getContent());
		res.put("product", news.getProduct());
		
		return new Result(2000, "成功", res);
	}
}
