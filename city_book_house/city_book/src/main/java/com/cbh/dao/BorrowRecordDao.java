package com.cbh.dao;

import java.util.List;
import java.util.Map;

import com.cbh.pojo.BookWithComment;

public interface BorrowRecordDao {
	List<List<?>> getBorrowRecordList(Map<?,?> param);
	
	int addBorrowRecordByUserId(Map<?,?> param);
	
	int getMyRecordNow(int user_id);
	
	int getMyRecordHistory(int user_id);
	
	int getMyRecordViolation(int user_id);
	
	List<List<?>> getMyRecordList(Map<?,?> param);
	
	List<Map<String, String>> countCategory(int user_id);
	
	int addMul(List<Map<String, Object>> param);
	
	int returnMul(Map<?,?> param);
	
	int renew(Map<?,?> param);
	
	List<BookWithComment> getBookReturned(int user_id);
}
