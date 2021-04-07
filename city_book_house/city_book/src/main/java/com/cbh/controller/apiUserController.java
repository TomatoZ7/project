package com.cbh.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cbh.domain.User;
import com.cbh.service.BorrowRecordService;
import com.cbh.service.UserService;
import com.cbh.utils.Result;

@RequestMapping(value = "/api/user")
@RestController
public class apiUserController {
	@Autowired
	UserService userService;
	@Autowired
	BorrowRecordService borrowRecordService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User login(@RequestBody User user) {
		// 加密密码
    	String pwd = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
    	user.setPassword(pwd);
    	
    	User loginUser = userService.getUserByLogin(user);
    	if (loginUser == null) {
			return new User();
		}
    	
    	// 统计当前借阅数量
    	int nowBorrow = borrowRecordService.getMyRecordNow(loginUser.getId());
    	
    	int borrowNum = 5 - nowBorrow;
    	if (loginUser.getManager_id() > 0) {
    		borrowNum = 10 - nowBorrow;
    	}
    	
    	loginUser.setBorrow_num(borrowNum);
    	return loginUser;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public User register(@RequestBody User user) {
		// 加密密码
    	String pwd = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
    	user.setPassword(pwd);
    	
    	user.setCode(UUID.randomUUID().toString().replace("-", ""));
    	user.setName(user.getAccount());
    	user.setStatus(1);
    	user.setAuth(2);
    	
    	int result = userService.register(user);
    	if (result == 0) {
			return new User();
		}
    	
    	user.setBorrow_num(5);
    	return user;
	}
	
	@RequestMapping(value = "/reset_pwd", method = RequestMethod.POST)
	public Result resetPwd(@RequestBody Map<String, String> params) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("old_pwd", DigestUtils.md5DigestAsHex(params.get("old_pwd").getBytes()));
		param.put("account", params.get("account"));
		param.put("new_pwd", DigestUtils.md5DigestAsHex(params.get("new_pwd").getBytes()));
		param.put("user_id", params.get("user_id"));
		
		int result = userService.resetPwd(param);
		if (result == 0) {
        	return new Result(403, "失败。");
        }

        return new Result(200, "成功。");
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Result update(@PathVariable int id, @RequestBody User user) {
		user.setId(id);
		
		int result = userService.apiUpdateUser(user);
		if (result == 0) {
        	return new Result(403, "失败。");
        }

        return new Result(200, "成功。");
	}
}
