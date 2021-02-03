package com.cbh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbh.domain.Book;
import com.cbh.domain.Browse;
import com.cbh.pojo.BookWithComment;
import com.cbh.pojo.apiBookDetail;
import com.cbh.service.BookService;
import com.cbh.service.BrowseService;

@RequestMapping(value = "/api/book")
@RestController
public class apiBookController {
	@Autowired
	BookService bookservice;
	@Autowired
	BrowseService browseService;

	/**
	 * ÍÆ¼ö
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/recommend", method = RequestMethod.GET)
	public List<Book> index(@RequestParam String recommend){
		List<Book> list;
		
		switch (recommend) {
		case "new":
			list = bookservice.getBookOfNew();
			break;
		case "borrow":
			list = bookservice.getBookOfHighBorrow();
			break;

		default:
			list = bookservice.getBookOfPopular();
		}
		
		return list;
	}
	
	/**
	 * ËÑË÷
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public HashMap<String, Object> search(@RequestParam Integer offset, @RequestParam Integer limit, String content,
														String column, String order, Integer second_category_id){
		column = (column.equals("collect_count") || column.equals("score")) ? column : "book.book_name";
		order = order.equals("asc") ? "asc" : order;
		
		Map<String,Object> param = new HashMap<>();
		param.put("offset", offset);
		param.put("limit", limit);
		param.put("content", content.isEmpty() ? null : content);
		param.put("second_category_id", second_category_id);
		param.put("column", column);
		param.put("order", order);

		List<List<?>> list = bookservice.searchBook(param);
		
		HashMap<String,Object> res = new HashMap<>();
		res.put("data", list.get(0));
		res.put("total", list.get(1).get(0));
		return res;
	}
	
	/**
	 * Êé¼®ÏêÇé Ìí¼Óä¯ÀÀ¼ÇÂ¼
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public apiBookDetail getBookByid(@PathVariable Integer id, Integer user_id) {
		if (user_id == null) {
			user_id = 0;
		}
		
		HashMap<String, Integer> param = new HashMap<>();
		param.put("id", id);
		param.put("user_id", user_id);
		
		apiBookDetail book = bookservice.getBookDetail(param);
		if (book == null) {
        	return new apiBookDetail();
        }
		
		// ä¯ÀÀ¼ÇÂ¼
		Browse browse = new Browse();
		browse.setBook_id(id);
		browse.setUser_id(user_id);
		browse.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		browseService.insertBrowse(browse);
		
        return book;
	}
}
