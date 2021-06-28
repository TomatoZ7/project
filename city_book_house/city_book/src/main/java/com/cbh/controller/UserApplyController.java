package com.cbh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbh.service.UserApplyService;
import com.cbh.service.UserService;
import com.cbh.utils.Result;

@RequestMapping(value = "/user_apply")
@RestController
public class UserApplyController {
	@Autowired
	UserApplyService userApplyService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public HashMap<?,?> index(@RequestParam Integer offset, @RequestParam Integer limit, @RequestParam List<Integer> status){
		Map<String,Object> param = new HashMap<>();
		param.put("offset", offset);
		param.put("limit", limit);
		param.put("status", status);

		List<List<?>> list = userApplyService.getUserApplyList(param);
		
		HashMap<String,Object> res = new HashMap<>();
		res.put("data", list.get(0));
		res.put("total", list.get(1).get(0));
		return res;
	}
	
	@RequestMapping(value = "/verify", method = RequestMethod.PUT)
	public Result verifyUser(@RequestBody Map<String, Object> params) {
		userApplyService.verifyUserApply(params);
		
		int result = userService.verifyUser(params);
		if (result == 0) {
        	return new Result(403, "Ê§°Ü¡£");
        }

        return new Result(200, "³É¹¦¡£");
	}
}
