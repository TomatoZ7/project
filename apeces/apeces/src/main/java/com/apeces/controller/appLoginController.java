package com.apeces.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apeces.domain.User;
import com.apeces.service.UserService;
import com.apeces.utils.Result;

@RequestMapping(value = "/api")
@RestController
public class appLoginController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Result register(@RequestBody User user) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		
		int result = userService.register(user);
        if (result == 0) {
        	return new Result(4003, "失败,该手机号已注册。", null);
        }
        
        User u = userService.login(user);
        
        Map<String, Object> res = new HashMap<String, Object>();
		res.put("id", u.getId());
		res.put("nick_name", u.getNickname());

        return new Result(2000, "成功。", res);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public Result login(@RequestParam String phone, @RequestParam String password) {
		User user = new User();
		user.setPhone(phone);
		user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
		
		User u = userService.login(user);
		if (u == null) {
        	return new Result(4003, "失败。", null);
        }

		Map<String, Object> res = new HashMap<String, Object>();
		res.put("id", u.getId());
		res.put("nick_name", u.getNickname());
		
        return new Result(2000, "成功。", res);
	}
}
