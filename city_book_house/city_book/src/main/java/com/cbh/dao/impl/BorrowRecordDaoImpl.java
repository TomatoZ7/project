package com.cbh.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbh.dao.BorrowRecordDao;
import com.cbh.pojo.BookWithComment;

@Component
public class BorrowRecordDaoImpl implements BorrowRecordDao {
	@Autowired
    SqlSessionTemplate ssTemplate;

	@Override
	public List<List<?>> getBorrowRecordList(Map<?,?> param) {
		// TODO Auto-generated method stub
		return ssTemplate.getMapper(BorrowRecordDao.class).getBorrowRecordList(param);
	}
	
	@Override
	public int addBorrowRecordByUserId(Map<?,?> param){
		return ssTemplate.getMapper(BorrowRecordDao.class).addBorrowRecordByUserId(param);
	}
	
	@Override
	public int getMyRecordNow(int user_id){
		return ssTemplate.getMapper(BorrowRecordDao.class).getMyRecordNow(user_id);
	}
	
	@Override
	public int getMyRecordHistory(int user_id){
		return ssTemplate.getMapper(BorrowRecordDao.class).getMyRecordHistory(user_id);
	}
	
	@Override
	public int getMyRecordViolation(int user_id){
		return ssTemplate.getMapper(BorrowRecordDao.class).getMyRecordViolation(user_id);
	}

	@Override
	public List<List<?>> getMyRecordList(Map<?,?> param) {
		return ssTemplate.getMapper(BorrowRecordDao.class).getMyRecordList(param);
	}
	
	@Override
	public List<Map<String, String>> countCategory(int user_id){
		return ssTemplate.getMapper(BorrowRecordDao.class).countCategory(user_id);
	}
	
	@Override
	public int addMul(List<Map<String, Object>> param) {
		return ssTemplate.getMapper(BorrowRecordDao.class).addMul(param);
	}
	
	@Override
	public int returnMul(Map<?,?> param) {
		return ssTemplate.getMapper(BorrowRecordDao.class).returnMul(param);
	}
	
	@Override
	public int renew(Map<?,?> param) {
		return ssTemplate.getMapper(BorrowRecordDao.class).renew(param);
	}
	
	@Override
	public List<BookWithComment> getBookReturned(int user_id) {
		return ssTemplate.getMapper(BorrowRecordDao.class).getBookReturned(user_id);
	}
}
