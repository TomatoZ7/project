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
	 * 借阅一本书籍，点击借阅能够加入借阅车并给予提示
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result insertBorrowRecord(@RequestBody Map<String, Object> params) {
		// 借阅数额
		UserCenter userCenter = userService.getUserWithBalance((int)params.get("user_id"));
		int num = userCenter.getManager_id() > 0 ? 10 : 5;
		if (userCenter.getBalance() >= num) {
			return new Result(403, "借阅失败，当前书籍借阅数量已达上限。");
		}
		
		// 初始化时间
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		params.put("create_time", now.format(formatter));
		
		int result = borrowCarService.insertSingle(params);
        if (result == 0) {
        	return new Result(403, "借阅失败，已借阅。");
        }
        
        // 书籍库存 -1
        int book_id = (int)params.get("book_id");
        bookService.borrowBookCallback(book_id);

        return new Result(200, "成功。");
	}
	
	/**
	 * 我的借阅统计
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
	 * 我的借阅列表
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
	 * 从借阅车批量借阅
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/addM", method = RequestMethod.POST)
	public Result insertM(@RequestBody Map<String, Object> params) {
		List<Integer> ids = (List<Integer>)params.get("ids");
		
		// 借阅数额
		UserCenter userCenter = userService.getUserWithBalance((int)params.get("user_id"));
		int num = userCenter.getManager_id() > 0 ? 10 : 5;
		if (userCenter.getBalance() + ids.size() >= num) {
			return new Result(403, "借阅失败，当前书籍借阅数量已达上限。");
		}
		
		// 初始化时间
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		List<Map<String, Object>> param = new ArrayList<Map<String, Object>>();
		
		for (Integer index : ids) {
			HashMap<String, Object> single = new HashMap<String, Object>();
			single.put("book_id", index);
			single.put("user_id", (int)params.get("user_id"));
			single.put("status", 1);
			single.put("start_time", now.format(formatter));
			single.put("end_time", now.plusMonths(1).format(formatter));	// 1 个月
			single.put("create_time", now.format(formatter));
			
			param.add(single);
		}
		
		int result = borrowRecordService.addMul(param);
		if (result == 0) {
        	return new Result(403, "失败。");
        }

		// 删除借阅车
		HashMap<String, Object> carParam = new HashMap<String, Object>();
		carParam.put("user_id", (int)params.get("user_id"));
		carParam.put("book_ids", ids);
		borrowCarService.deleteM(carParam);
		
		return new Result(200, "成功。");
	}
	
	/**
	 * 批量归还
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/returnM", method = RequestMethod.PUT)
	public Result returnM(@RequestBody Map<String, Object> params) {
		// 初始化时间
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		params.put("return_time", now.format(formatter));
		params.put("status", 4);
		
		int result = borrowRecordService.returnMul(params);
		if (result == 0) {
        	return new Result(403, "失败。");
        }
		
		// 更新库存
		bookService.returnBookCallback((List<Integer>)params.get("ids"));
		
		return new Result(200, "成功。");
	}
	
	/**
	 * 续借
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/renew", method = RequestMethod.PUT)
	public Result renew(@RequestBody Map<String, Object> params) {
		params.put("status", 2);
		
		int result = borrowRecordService.renew(params);
		if (result == 0) {
        	return new Result(403, "失败。");
        }
		
		return new Result(200, "成功。");
	}
	
	/**
	 * 归还记录（我的评价）
	 * 
	 * @param user_id
	 * @return
	 */
	@RequestMapping(value = "/returned", method = RequestMethod.GET)
	public List<BookWithComment> getBookNoComment(@RequestParam Integer user_id){
		return borrowRecordService.getBookReturned(user_id);
	}
}
