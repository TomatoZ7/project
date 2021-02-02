package com.cbh.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "api/carousel")
@RestController
public class apiCarouselController {
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Object> index(){
		HashMap<String, Object> firstCarousel = new HashMap<String, Object>();
		firstCarousel.put("book_id", 1);
		firstCarousel.put("image", "/upload/static/first.jpg");
		
		HashMap<String, Object> secondCarousel = new HashMap<String, Object>();
		secondCarousel.put("book_id", 2);
		secondCarousel.put("image", "/upload/static/second.jpg");
		
		HashMap<String, Object> thirdCarousel = new HashMap<String, Object>();
		thirdCarousel.put("book_id", 3);
		thirdCarousel.put("image", "/upload/static/third.jpg");
		
		List<Object> res = new ArrayList<Object>();
		res.add(firstCarousel);
		res.add(secondCarousel);
		res.add(thirdCarousel);
		
		return res;
	}
}
