package com.cbh.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbh.pojo.BookWithComment;
import com.cbh.pojo.UserCenter;
import com.cbh.service.BookService;
import com.cbh.service.BorrowCarService;
import com.cbh.service.BorrowRecordService;
import com.cbh.service.UserService;
import com.cbh.utils.Result;

@RequestMapping(value = "/api/borrow_record")
@RestController
public class apiBorrowRecordController {
	@Autowired
	BorrowRecordService borrowRecordService;
	@Autowired
	BookService bookService;
	@Autowired
	BorrowCarService borrowCarService;
	@Autowired
	UserService userService;
	
	/**
	 * ����һ���鼮����������ܹ�������ĳ���������ʾ
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result insertBorrowRecord(@RequestBody Map<String, Object> params) {
		// ��������
		UserCenter userCenter = userService.getUserWithBalance((int)params.get("user_id"));
		int num = userCenter.getManager_id() > 0 ? 10 : 5;
		if (userCenter.getBalance() >= num) {
			return new Result(403, "����ʧ�ܣ���ǰ�鼮���������Ѵ����ޡ�");
		}
		
		// ��ʼ��ʱ��
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		params.put("create_time", now.format(formatter));
		
		int result = borrowCarService.insertSingle(params);
        if (result == 0) {
        	return new Result(403, "����ʧ�ܣ��ѽ��ġ�");
        }
        
        // �鼮��� -1
        int book_id = (int)params.get("book_id");
        bookService.borrowBookCallback(book_id);

        return new Result(200, "�ɹ���");
	}
	
	/**
	 * �ҵĽ���ͳ��
	 * 
	 * @param user_id
	 * @return
	 */
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public Map<?,?> count(@RequestParam Integer user_id){
		HashMap<String, Object> res = new HashMap<String, Object>();
		res.put("now", borrowRecordService.getMyRecordNow(user_id));
		res.put("history", borrowRecordService.getMyRecordHistory(user_id));
		res.put("violation", borrowRecordService.getMyRecordViolation(user_id));
		res.put("count", borrowRecordService.countCategory(user_id));
		
		return res;
	}
	
	/**
	 * �ҵĽ����б�
	 * 
	 * @param offset
	 * @param limit
	 * @param user_id
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Map<?,?> index(@RequestParam Integer offset, @RequestParam Integer limit,
							@RequestParam Integer user_id, @RequestParam String type){
		Map<String,Object> param = new HashMap<>();
		param.put("offset", offset);
		param.put("limit", limit);
		param.put("user_id", user_id);
		param.put("type", type);
		
		List<List<?>> list = borrowRecordService.getMyRecordList(param);
		
		HashMap<String,Object> res = new HashMap<>();
		res.put("data", list.get(0));
		res.put("total", list.get(1).get(0));
		return res;
	}
	
	/**
	 * �ӽ��ĳ���������
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/addM", method = RequestMethod.POST)
	public Result insertM(@RequestBody Map<String, Object> params) {
		List<Integer> ids = (List<Integer>)params.get("ids");
		
		// ��������
		UserCenter userCenter = userService.getUserWithBalance((int)params.get("user_id"));
		int num = userCenter.getManager_id() > 0 ? 10 : 5;
		if (userCenter.getBalance() + ids.size() >= num) {
			return new Result(403, "����ʧ�ܣ���ǰ�鼮���������Ѵ����ޡ�");
		}
		
		// ��ʼ��ʱ��
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		List<Map<String, Object>> param = new ArrayList<Map<String, Object>>();
		
		for (Integer index : ids) {
			HashMap<String, Object> single = new HashMap<String, Object>();
			single.put("book_id", index);
			single.put("user_id", (int)params.get("user_id"));
			single.put("status", 1);
			single.put("start_time", now.format(formatter));
			single.put("end_time", now.plusMonths(1).format(formatter));	// 1 ����
			single.put("create_time", now.format(formatter));
			
			param.add(single);
		}
		
		int result = borrowRecordService.addMul(param);
		if (result == 0) {
        	return new Result(403, "ʧ�ܡ�");
        }

		// ɾ�����ĳ�
		HashMap<String, Object> carParam = new HashMap<String, Object>();
		carParam.put("user_id", (int)params.get("user_id"));
		carParam.put("book_ids", ids);
		borrowCarService.deleteM(carParam);
		
		return new Result(200, "�ɹ���");
	}
	
	/**
	 * �����黹
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/returnM", method = RequestMethod.PUT)
	public Result returnM(@RequestBody Map<String, Object> params) {
		// ��ʼ��ʱ��
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		params.put("return_time", now.format(formatter));
		params.put("status", 4);
		
		int result = borrowRecordService.returnMul(params);
		if (result == 0) {
        	return new Result(403, "ʧ�ܡ�");
        }
		
		// ���¿��
		bookService.returnBookCallback((List<Integer>)params.get("ids"));
		
		return new Result(200, "�ɹ���");
	}
	
	/**
	 * ����
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/renew", method = RequestMethod.PUT)
	public Result renew(@RequestBody Map<String, Object> params) {
		params.put("status", 2);
		
		int result = borrowRecordService.renew(params);
		if (result == 0) {
        	return new Result(403, "ʧ�ܡ�");
        }
		
		return new Result(200, "�ɹ���");
	}
	
	/**
	 * �黹��¼���ҵ����ۣ�
	 * 
	 * @param user_id
	 * @return
	 */
	@RequestMapping(value = "/returned", method = RequestMethod.GET)
	public List<BookWithComment> getBookNoComment(@RequestParam Integer user_id){
		return borrowRecordService.getBookReturned(user_id);
	}
}
