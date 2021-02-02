package com.apeces.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apeces.domain.Category;
import com.apeces.service.CategoryService;
import com.apeces.utils.Result;

@RequestMapping(value = "/admin/category")
@RestController
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result index(int shop_id, int offset, int limit) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("shop_id", shop_id);
		param.put("offset", offset);
		param.put("limit", limit);
		List<List<?>> list = categoryService.queryCate(param);
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("total", list.get(1).get(0));
		res.put("data", list.get(0));
		
		return new Result(2000, "成功", res);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result single(@PathVariable int id) {
		Category category = categoryService.queryCateSingle(id);
		
		if (category == null) {
			return new Result(4004, "未找到", null);
		}
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("id", category.getId());
		res.put("title", category.getCategory_name());
		
		return new Result(2000, "成功", res);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result add(@RequestBody Category category) {
		int result = categoryService.insertCate(category);
        if (result == 0) {
        	return new Result(5000, "失败。", null);
        }

        return new Result(2000, "成功。", null);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Result update(@PathVariable int id, @RequestBody Category category) {
		category.setId(id);
		int result = categoryService.editCate(category);
        if (result == 0) {
        	return new Result(5000, "失败。", null);
        }

        return new Result(2000, "成功。", null);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable int id) {
		int result = categoryService.delCate(id);
        if (result == 0) {
        	return new Result(5000, "失败。", null);
        }

        return new Result(2000, "成功。", null);
	}
}
