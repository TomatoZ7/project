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

import com.apeces.domain.Product;
import com.apeces.pojo.ProCatePivot;
import com.apeces.service.ProductService;
import com.apeces.utils.Result;

@RequestMapping(value = "/admin/product")
@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result index(int shop_id, int offset, int limit) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("shop_id", shop_id);
		param.put("offset", offset);
		param.put("limit", limit);
		List<List<?>> list = productService.queryProByShop(param);
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("total", list.get(1).get(0));
		res.put("data", list.get(0));
		
		return new Result(2000, "�ɹ�", res);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result single(@PathVariable int id) {
		ProCatePivot pro = productService.queryPro(id);
		
		if (pro == null) {
			return new Result(4004, "δ�ҵ�", null);
		}
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("id", pro.getId());
		res.put("name", pro.getName());
		res.put("price", pro.getPrice());
		res.put("unit", pro.getUnit());
		res.put("category_id", pro.getCategory_id());
		res.put("cover_img", pro.getCover_img());
		res.put("introduction", pro.getIntroduction());
		res.put("detail_img", pro.getDetail_img());
		res.put("shop_id", pro.getCategory_name());
		
		return new Result(2000, "�ɹ�", res);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result add(@RequestBody Product pro) {
		int result = productService.insertPro(pro);
        if (result == 0) {
        	return new Result(5000, "ʧ�ܡ�", null);
        }

        return new Result(2000, "�ɹ���", null);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Result edit(@PathVariable int id, @RequestBody Product pro) {
		pro.setId(id);
		int result = productService.editPro(pro);
        if (result == 0) {
        	return new Result(5000, "ʧ�ܡ�", null);
        }

        return new Result(2000, "�ɹ���", null);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable int id) {
		int result = productService.delPro(id);
        if (result == 0) {
        	return new Result(5000, "ʧ�ܡ�", null);
        }

        return new Result(2000, "�ɹ���", null);
	}
}
