package com.apeces.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apeces.service.ManagerService;
import com.apeces.service.ShopService;
import com.apeces.utils.Result;
import com.apeces.domain.Manager;
import com.apeces.domain.Shop;

@RequestMapping(value = "/admin/manager")
@RestController
public class ManagerController {
	@Autowired
	ManagerService managerService;
	@Autowired
	ShopService shopService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Result login(@RequestBody Manager manager) {
		// 加密密码
    	String pwd = DigestUtils.md5DigestAsHex(manager.getPassword().getBytes());
    	manager.setPassword(pwd);
    	
		Manager loginManager = managerService.login(manager);
		
		if (loginManager == null) {
			return new Result(4003, "登录失败", null);
		}
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("id", loginManager.getId());
		res.put("shop_id", loginManager.getShop_id());
		return new Result(2000, "登录成功", res);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result index(Integer limit, Integer offset) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("offset", offset);
		param.put("limit", limit);
		List<List<?>> list = managerService.queryManager(param);
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("total", list.get(1).get(0));
		res.put("data", list.get(0));
		
		return new Result(2000, "成功", res);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result single(@PathVariable Integer id) {
		Manager manager = managerService.queryManagerSingle(id);
		
		if (manager == null) {
			return new Result(4004, "未找到", null);
		}
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("id", manager.getId());
		res.put("phone", manager.getPhone());
		res.put("shop", manager.getShop());
		
		return new Result(2000, "成功", res);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result add(@RequestBody Map<String, Object> params) {
		String phone = (String)params.get("phone");
		String pwd = (String)params.get("password");
		String name = (String)params.get("name");
		String logo = (String)params.get("logo");
		
    	String password = DigestUtils.md5DigestAsHex(pwd.getBytes());
		
		Shop shop = new Shop(0, name, phone, logo, "");
		shopService.insertShop(shop);

		Manager m = new Manager(0, phone, password, shop.getId());
		int result = managerService.insertManager(m);
        if (result == 0) {
        	return new Result(5000, "失败。", null);
        }

        return new Result(2000, "成功。", null);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable Integer id) {
		int result = managerService.delManager(id);
        if (result == 0) {
        	return new Result(5000, "失败。", null);
        }

        return new Result(2000, "成功。", null);
	}
}
