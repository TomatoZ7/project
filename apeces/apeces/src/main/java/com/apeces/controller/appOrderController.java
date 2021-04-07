package com.apeces.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apeces.domain.Order;
import com.apeces.pojo.AppOrder;
import com.apeces.pojo.AppProDetail;
import com.apeces.service.LogisticsService;
import com.apeces.service.OrderService;
import com.apeces.service.ProductService;
import com.apeces.utils.Result;

@RequestMapping(value = "/api/order")
@RestController
public class appOrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	LogisticsService logisticsService;
	@Autowired
	ProductService productService;
	
	/**
	 * ���ɶ���
	 * 
	 * @param addr
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result generate(@RequestBody Order order) {
		Random r = new Random();
		order.setOrder_no("" + (r.nextInt(9999999-1000000+1)+1000000));
		order.setStatus(1);
		order.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		int result = orderService.genOrder(order);
        if (result == 0) {
        	return new Result(5000, "ʧ�ܡ�", null);
        }
        
        Map<String, Object> res = new HashMap<String, Object>();
		res.put("id", order.getId());
		res.put("status", order.getStatus());

        return new Result(2000, "�ɹ���", res);
	}
	
	/**
	 * ����֧��
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/pay/{id}", method = RequestMethod.PUT)
	public Result pay(@PathVariable final Integer id) {
		AppOrder order = orderService.queryAppOrder(id);
		
		if (order.getStatus() != 1) {
			return new Result(4003, "��ǰ�������ڲ���֧��״̬", null);
		}
		
		AppProDetail product = productService.queryAppProDetail(order.getProduct_id());
		
		if (product == null) {
			return new Result(4003, "��Ʒ���¼�", null);
		}
		
		if (product.getNums() < order.getNums()) {
			return new Result(4003, "��治��", null);
		}else {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("nums", product.getNums() - order.getNums());
			param.put("id", order.getProduct_id());
			productService.updateNums(param);
		}
		
		int result = orderService.payOrder(id);
        if (result == 0) {
        	return new Result(5000, "ʧ�ܡ�", null);
        }
        
        List<Map<String, Object>> log = new ArrayList<Map<String, Object>>();
        log.add(new HashMap<String, Object>(){
        	{
        		put("order_id", id);
        		put("info", "�����ύ��������ȴ�ϵͳȷ��");
        		put("create_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        	}
        });
        log.add(new HashMap<String, Object>(){
        	{
        		put("order_id", id);
        		put("info", "����ȷ�ϣ���֪ͨ�̼����");
        		put("create_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        	}
        });
        logisticsService.genLog(log);

        return new Result(2000, "�ɹ���", null);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result index(Integer user_id, Integer offset, Integer limit) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("user_id", user_id);
		param.put("offset", offset);
		param.put("limit", limit);
		List<List<?>> list = orderService.queryAppOrderByUser(param);
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("total", list.get(1).get(0));
		res.put("data", list.get(0));
		
		return new Result(2000, "�ɹ�", res);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result single(@PathVariable Integer id) {
		AppOrder order = orderService.queryAppOrder(id);
		
		if (order == null) {
			return new Result(4004, "δ�ҵ�", null);
		}
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("id", order.getId());
		res.put("order_no", order.getOrder_no());
		res.put("nums", order.getNums());
		res.put("amount", order.getAmount());
		res.put("status", order.getStatus());
		
		res.put("product_id", order.getProduct_id());
		res.put("product_name", order.getProduct_name());
		res.put("product_cover_img", order.getProduct_cover_img());
		
		res.put("shop_id", order.getShop_id());
		res.put("shop_name", order.getShop_name());
		res.put("shop_phone", order.getShop_phone());
		
		res.put("address_id", order.getAddress_id());
		res.put("address_name", order.getAddress_name());
		res.put("address_phone", order.getAddress_phone());
		res.put("address", order.getAddress());
		
		return new Result(2000, "�ɹ�", res);
	}
	
	/**
	 * �ߵ�
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/remind/{id}", method = RequestMethod.PUT)
	public Result remind(@PathVariable Integer id) {
		int result = orderService.remind(id);
		if (result == 0) {
			return new Result(4003, "�Ѵߵ�,�����ĵȴ�", null);
		}
		
		return new Result(2000, "��֪ͨ�̼Ҿ��촦��", null);
	}
	
	/**
	 * �˿�
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/refund/{id}", method = RequestMethod.PUT)
	public Result refund(@PathVariable Integer id) {
		AppOrder order = orderService.queryAppOrder(id);
		
		if (order.getStatus() > 3) {
			return new Result(4003, "��ǰ�������˿�������˿�", null);
		}
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("status", order.getStatus() == 3 ? 4 : 5);
		
		int result = orderService.refund(param);
		if (result == 0) {
			return new Result(5000, "ʧ��", null);
		}
		
		String msg = order.getStatus() == 3 ? "�������˿�" : "�˿�ɹ�";
		return new Result(2000, msg, null);
	}
}
