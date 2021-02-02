package com.apeces.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apeces.service.CommentService;
import com.apeces.utils.Result;

@RequestMapping(value = "/admin/comment")
@RestController
public class CommentController {
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result index(int shop_id, int offset, int limit) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("shop_id", shop_id);
		param.put("offset", offset);
		param.put("limit", limit);
		List<List<?>> list = commentService.queryCommByShop(param);
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("total", list.get(1).get(0));
		res.put("data", list.get(0));
		
		return new Result(2000, "成功", res);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable int id) {
		int result = commentService.delComm(id);
        if (result == 0) {
        	return new Result(5000, "失败。", null);
        }

        return new Result(2000, "成功。", null);
		
	}
}
