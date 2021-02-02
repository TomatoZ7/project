package com.cbh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cbh.domain.Category;
import com.cbh.pojo.firstCategory;
import com.cbh.service.CategoryService;

@RequestMapping(value = "/api/category")
@RestController
public class apiCategoryController {
	@Autowired
    CategoryService categoryService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Category> index(){
		List<Category> list = categoryService.getIndexCategory();

		return list;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<firstCategory> all(){
		List<firstCategory> list = categoryService.getCategory();
		
		return list;
	}
}
