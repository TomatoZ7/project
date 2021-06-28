package com.cbh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbh.domain.Manager;
import com.cbh.domain.User;
import com.cbh.service.ManagerService;
import com.cbh.service.UserService;
import com.cbh.utils.Result;

@RequestMapping(value = "/manager")
@RestController
public class ManagerController {
	@Autowired
    ManagerService managerService;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Manager login(@RequestBody Manager manager) {
		// 加密密码
    	String pwd = DigestUtils.md5DigestAsHex(manager.getPassword().getBytes());
    	manager.setPassword(pwd);
		
		Manager login = managerService.getManagerByLogin(manager);
		
		if (login == null) {
			return new Manager();
        }
		return login;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public HashMap<?,?> index(
			@RequestParam Integer offset, 
			@RequestParam Integer limit, 
			@RequestParam Integer status,
			@RequestParam String content) {
		Map<String,Object> param = new HashMap<>();
		param.put("offset", offset);
		param.put("limit", limit);
		param.put("status", status);
		param.put("content", content);
		
		List<List<?>> list = managerService.getManagerList(param);
		
		HashMap<String,Object> res = new HashMap<>();
		res.put("data", list.get(0));
		res.put("total", list.get(1).get(0));
		return res;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Manager getManagerById(@PathVariable int id) {
        Manager Manager = managerService.getManagerById(id);
        if (Manager == null) {
        	return new Manager();
        }
        return Manager;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result addManager(@RequestBody Manager Manager) {
    	// 初始密码123456
    	String initPwd = DigestUtils.md5DigestAsHex("123456".getBytes());
    	Manager.setPassword(initPwd);
    	
    	// 设置创建时间
    	Manager.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    	
    	Manager.setStatus(1);
    	Manager.setHas_rights(2);
    	
        int result = managerService.insertManager(Manager);
        if (result == 0) {
        	return new Result(403, "添加失败，该账号或手机号已存在。");
        }
        
        // user 账号
        User user = new User();
        user.setAccount(Manager.getAccount());
        user.setPhone(Manager.getPhone());
        
        User userExists = userService.recheckUser(user);
        if (userExists == null) {
        	// add
			user.setCode(UUID.randomUUID().toString().replace("-", ""));
			user.setName(Manager.getName());
			user.setGender(Manager.getGender());
			user.setPassword(initPwd);
			user.setStatus(1);
			user.setAuth(1);
			user.setManager_id(Manager.getId());
			
			userService.insertUser(user);
		}else {
			// update
			userExists.setStatus(1);
			userExists.setAuth(1);
			userExists.setManager_id(Manager.getId());
			
			userService.updateUser(userExists);
		}

        return new Result(200, "添加成功。");
    }
    
    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public Result updateManager(@PathVariable int id, @RequestBody Manager paramManager){
    	paramManager.setId(id);
    	
        int result = managerService.updateManager(paramManager);
        if (result == 0) {
        	return new Result(403, "更新失败。");
        }

        return new Result(200, "更新成功。");
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delManagerById(@PathVariable int id) {
        int res = managerService.delManagerById(id);
        if (res == 0) {
        	return new Result(403, "删除失败");
        }

        return new Result(200, "删除操作成功");
    }

	@RequestMapping(value = "/enable_batch", method = RequestMethod.PUT)
	public Result bulk_operate(@RequestBody Map<String, Object> params) {
		int result = managerService.updateManagerBatch(params);
		
		if (result == 0) {
        	return new Result(403, "失败。");
        }

        return new Result(200, "成功。");
	}
}
