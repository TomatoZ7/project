package com.cbh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbh.dao.BorrowRecordDao;
import com.cbh.pojo.BookWithComment;
import com.cbh.service.BorrowRecordService;

@Service
public class BorrowRecordServiceImpl implements BorrowRecordService {
	@Autowired
	BorrowRecordDao borrowRecordDao;
	
	@Override
	public List<List<?>> getBorrowRecordList(Map<?,?> param) {
		return borrowRecordDao.getBorrowRecordList(param);
	}
	
	@Override
	public int addBorrowRecordByUserId(Map<?,?> param) {
		return borrowRecordDao.addBorrowRecordByUserId(param);
	}
	
	@Override
	public int getMyRecordNow(int user_id) {
		return borrowRecordDao.getMyRecordNow(user_id);
	}
	
	@Override
	public int getMyRecordHistory(int user_id) {
		return borrowRecordDao.getMyRecordHistory(user_id);
	}
	
	@Override
	public int getMyRecordViolation(int user_id) {
		return borrowRecordDao.getMyRecordViolation(user_id);
	}
	
	@Override
	public List<List<?>> getMyRecordList(Map<?,?> param) {
		return borrowRecordDao.getMyRecordList(param);
	}
	
	@Override
	public List<Map<String, String>> countCategory(int user_id) {
		return borrowRecordDao.countCategory(user_id);
	}
	
	@Override
	public int addMul(List<Map<String, Object>> param) {
		return borrowRecordDao.addMul(param);
	}
	
	@Override
	public int returnMul(Map<?,?> param) {
		return borrowRecordDao.returnMul(param);
	}
	
	@Override
	public int renew(Map<?,?> param) {
		return borrowRecordDao.renew(param);
	}
	
	@Override
	public List<BookWithComment> getBookReturned(int user_id){
		return borrowRecordDao.getBookReturned(user_id);
	}
}
