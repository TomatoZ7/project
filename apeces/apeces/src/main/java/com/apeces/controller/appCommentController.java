package com.apeces.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apeces.service.CommentService;
import com.apeces.utils.Result;

@RequestMapping(value = "/api/comment")
@RestController
public class appCommentController {
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result index(Integer shop_id, Integer offset, Integer limit, Integer user_id, Integer product_id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("shop_id", shop_id);
		param.put("offset", offset);
		param.put("limit", limit);
		param.put("user_id", user_id);
		param.put("product_id", product_id);
		List<List<?>> list = commentService.queryAppComm(param);
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("total", list.get(1).get(0));
		res.put("data", list.get(0));
		
		return new Result(2000, "�ɹ�", res);
	}
}
