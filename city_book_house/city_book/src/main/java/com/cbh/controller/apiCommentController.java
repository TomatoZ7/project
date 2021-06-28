package com.cbh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbh.domain.Comment;
import com.cbh.service.CommentService;
import com.cbh.utils.Result;
import com.cbh.utils.SensitiveWord;

@RequestMapping(value = "/api/comment")
@RestController
public class apiCommentController {
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public HashMap<String, Object> index(@RequestParam Integer offset, @RequestParam Integer limit, Integer book_id){
		Map<String,Object> param = new HashMap<>();
		param.put("offset", offset);
		param.put("limit", limit);
		param.put("book_id", book_id);
		
		List<List<?>> list = commentService.getCommentList(param);
		
		HashMap<String,Object> res = new HashMap<>();
		res.put("data", list.get(0));
		res.put("total", list.get(1).get(0));
		return res;
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result comment(@RequestBody Comment comment) {
		// Î¥½û´Ê¼ìË÷
		String content = comment.getContent();
		if (!SensitiveWord.search(content)) {
			return new Result(403, "ÆÀÂÛÄÚÈÝº¬ÓÐÎ¥½û´Ê£¡");
		}
		
		comment.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		int result = commentService.insertComment(comment);
		
		if (result == 0) {
        	return new Result(403, "Ê§°Ü¡£");
        }

        return new Result(200, "³É¹¦¡£");
	}
}
