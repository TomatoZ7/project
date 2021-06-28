package com.cbh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbh.domain.Browse;
import com.cbh.service.BrowseService;

@RequestMapping(value = "/api/browse")
@RestController
public class apiBrowseController {
	@Autowired
	BrowseService browseService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Browse> getCarList(@RequestParam Integer user_id){
//		Map<String,Integer> param = new HashMap<>();
//		param.put("user_id", user_id);
		
		List<Browse> list = browseService.getBrowseList(user_id);
		
		return list;
	}
}
