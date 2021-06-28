package com.cbh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbh.domain.User;
import com.cbh.service.BorrowRecordService;
import com.cbh.service.UserService;
import com.cbh.utils.Result;

@RequestMapping(value = "/user")
@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	BorrowRecordService borrowRecordService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public HashMap<?,?> index(@RequestParam Integer offset, @RequestParam Integer limit, 
			Integer apply_status, String name, String phone, Integer status, Integer auth) {
		
		Map<String,Object> param = new HashMap<>();
		param.put("offset", offset);
		param.put("limit", limit);
		param.put("name", name);
		param.put("phone", phone);
		param.put("status", status);
		param.put("auth", auth);
		
		List<List<?>> list = userService.getUserList(param);
		
		HashMap<String,Object> res = new HashMap<>();
		res.put("data", list.get(0));
		res.put("total", list.get(1).get(0));
		return res;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUserByid(@PathVariable int id) {
		User user = userService.getUserById(id);
        if (user == null) {
        	return new User();
        }
        
        return user;
    }
	
	@RequestMapping(value = "/enable_batch", method = RequestMethod.PUT)
	public Result verifyUser(@RequestBody Map<String, Object> params) {
		int result = userService.updateUserBatch(params);
		
		if (result == 0) {
        	return new Result(403, "Ê§°Ü¡£");
        }

        return new Result(200, "³É¹¦¡£");
	}
}
