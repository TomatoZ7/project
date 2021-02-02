package com.cbh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cbh.domain.User;
import com.cbh.domain.UserApply;
import com.cbh.service.UserApplyService;
import com.cbh.service.UserService;
import com.cbh.utils.Result;

@RestController
public class apiUserApplyController {
	@Autowired
	UserApplyService userApplyService;
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/api/user/authenticate", method = RequestMethod.POST)
	public Result authenticate(@RequestBody UserApply userApply) {
		userApply.setStatus(3);
		userApply.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		int result = userApplyService.insertUserApply(userApply);
		if (result == 0) {
        	return new Result(403, "你已经认证过了");
        }
		
		// 更新 user 手机&性别
		User user = userService.getUserById(userApply.getUser_id());
		user.setPhone(userApply.getPhone());
		user.setGender(userApply.getGender());
		userService.updateUser(user);

        return new Result(200, "成功。");
	}
}
