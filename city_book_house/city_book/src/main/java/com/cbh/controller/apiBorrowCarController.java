package com.cbh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbh.domain.BorrowCar;
import com.cbh.service.BorrowCarService;
import com.cbh.utils.Result;

@RequestMapping(value = "/api/borrow_car")
@RestController
public class apiBorrowCarController {
	@Autowired
	BorrowCarService borrowCarService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<BorrowCar> getCarList(@RequestParam Integer user_id){
		Map<String,Integer> param = new HashMap<>();
		param.put("user_id", user_id);
		
		List<BorrowCar> list = borrowCarService.getBorrowCarList(param);
		
		return list;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result cancel(@PathVariable int id) {
		int result = borrowCarService.deleteById(id);
		
		if (result == 0) {
        	return new Result(403, "Ê§°Ü¡£");
        }

        return new Result(200, "³É¹¦¡£");
	}
}
