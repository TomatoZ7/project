package com.apeces.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apeces.domain.News;
import com.apeces.service.NewsService;
import com.apeces.utils.Result;

@RequestMapping(value = "/admin/news")
@RestController
public class NewsController {
	@Autowired
	NewsService newsService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result index(int shop_id, int offset, int limit) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("shop_id", shop_id);
		param.put("offset", offset);
		param.put("limit", limit);
		List<List<?>> list = newsService.queryNewsByShop(param);
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("total", list.get(1).get(0));
		res.put("data", list.get(0));
		
		return new Result(2000, "成功", res);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result single(@PathVariable int id) {
		News news = newsService.queryNews(id);
		
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
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result add(@RequestBody News news) {
		news.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		int result = newsService.insertNews(news);
        if (result == 0) {
        	return new Result(5000, "失败。", null);
        }

        return new Result(2000, "成功。", null);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Result update(@PathVariable int id, @RequestBody News news) {
		news.setId(id);
		int result = newsService.editNews(news);
        if (result == 0) {
        	return new Result(5000, "失败。", null);
        }

        return new Result(2000, "成功。", null);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable int id) {
		int result = newsService.delNews(id);
        if (result == 0) {
        	return new Result(5000, "失败。", null);
        }

        return new Result(2000, "成功。", null);
	}
}
