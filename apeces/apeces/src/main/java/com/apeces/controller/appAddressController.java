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

import com.apeces.domain.Address;
import com.apeces.service.AddressService;
import com.apeces.utils.Result;

@RequestMapping(value = "/api/address")
@RestController
public class appAddressController {
	@Autowired
	AddressService addressService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result index(Integer offset, Integer limit, Integer user_id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("offset", offset);
		param.put("limit", limit);
		param.put("user_id", user_id);
		List<List<?>> list = addressService.queryAddrByUser(param);
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("total", list.get(1).get(0));
		res.put("data", list.get(0));
		
		return new Result(2000, "成功", res);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result index(@PathVariable Integer id) {
		Address addr = addressService.queryAddr(id);
		
		if (addr == null) {
			return new Result(4004, "未找到", null);
		}
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("id", addr.getId());
		res.put("phone", addr.getPhone());
		res.put("name", addr.getName());
		res.put("address", addr.getAddress());
		
		return new Result(2000, "成功", res);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result add(@RequestBody Address addr) {
		int result = addressService.insertAddr(addr);
        if (result == 0) {
        	return new Result(5000, "失败。", null);
        }

        return new Result(2000, "成功。", null);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Result add(@PathVariable Integer id, @RequestBody Address addr) {
		addr.setId(id);
		int result = addressService.updateAddr(addr);
        if (result == 0) {
        	return new Result(4003, "失败。", null);
        }

        return new Result(2000, "成功。", null);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result add(@PathVariable Integer id) {
		int result = addressService.delAddr(id);
        if (result == 0) {
        	return new Result(4003, "失败。", null);
        }

        return new Result(2000, "成功。", null);
	}
}
