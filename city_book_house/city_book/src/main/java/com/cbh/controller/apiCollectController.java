package com.cbh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbh.domain.Collect;
import com.cbh.service.CollectService;
import com.cbh.utils.Result;

@RequestMapping(value = "/api/collect")
@RestController
public class apiCollectController {
	@Autowired
	CollectService collectService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Collect> getCarList(@RequestParam Integer user_id){
//		Map<String,Integer> param = new HashMap<>();
//		param.put("user_id", user_id);
		
		List<Collect> list = collectService.getCollectList(user_id);
		
		return list;
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result add(@RequestBody Collect collect){
		collect.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		int result = collectService.insertCollect(collect);
        if (result == 0) {
        	return new Result(403, "失败。");
        }

        return new Result(200, "成功。");
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable int id) {
		int result = collectService.deleteCollect(id);
		if (result == 0) {
        	return new Result(403, "失败。");
        }

        return new Result(200, "成功。");
	}
}
