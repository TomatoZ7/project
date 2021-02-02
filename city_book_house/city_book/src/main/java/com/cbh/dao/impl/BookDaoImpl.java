package com.cbh.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbh.dao.BookDao;
import com.cbh.domain.Book;
import com.cbh.domain.Comment;
import com.cbh.pojo.BookWithComment;
import com.cbh.pojo.apiBookDetail;

@Component
public class BookDaoImpl implements BookDao {
	@Autowired
    SqlSessionTemplate ssTemplate;
	
	@Override
	public List<List<?>> getBookList(Map param){
		return ssTemplate.getMapper(BookDao.class).getBookList(param);
	}
	
	@Override
	public Book getBookById(int id) {
		return ssTemplate.getMapper(BookDao.class).getBookById(id);
	}
	
	@Override
	public int insertBook(Book book) {
		return ssTemplate.getMapper(BookDao.class).insertBook(book);
	}
	
	@Override
	public int updateBook(Book book) {
		return ssTemplate.getMapper(BookDao.class).updateBook(book);
	}
	
	@Override
	public int delBookById(int id) {
		return ssTemplate.getMapper(BookDao.class).delBookById(id);
	}
	
	@Override
	public int countBook() {
		return ssTemplate.getMapper(BookDao.class).countBook();
	}
	
	@Override
	public List<Object> countBookByCategory(){
		return ssTemplate.getMapper(BookDao.class).countBookByCategory();
	}
	
	
	/******  ÒÆ¶¯¶Ë  *******/
	@Override
	public List<Book> getBookOfPopular(){
		return ssTemplate.getMapper(BookDao.class).getBookOfPopular();
	}
	
	@Override
	public List<Book> getBookOfNew(){
		return ssTemplate.getMapper(BookDao.class).getBookOfNew();
	}
	
	@Override
	public List<Book> getBookOfHighBorrow(){
		return ssTemplate.getMapper(BookDao.class).getBookOfHighBorrow();
	}
	
	@Override
	public List<List<?>> searchBook(Map param){
		return ssTemplate.getMapper(BookDao.class).searchBook(param);
	}
	
	@Override
	public apiBookDetail getBookDetail(Map<?,?> param) {
		return ssTemplate.getMapper(BookDao.class).getBookDetail(param);
	}
	
	@Override
	public int borrowBookCallback(int id) {
		return ssTemplate.getMapper(BookDao.class).borrowBookCallback(id);
	}
	
	@Override
	public int returnBookCallback(List<Integer> ids) {
		return ssTemplate.getMapper(BookDao.class).returnBookCallback(ids);
	}
}
