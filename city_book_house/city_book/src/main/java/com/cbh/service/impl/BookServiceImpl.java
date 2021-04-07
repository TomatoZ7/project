package com.cbh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbh.dao.BookDao;
import com.cbh.domain.Book;
import com.cbh.domain.Comment;
import com.cbh.pojo.BookWithComment;
import com.cbh.pojo.apiBookDetail;
import com.cbh.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookDao bookDao;
	
	@Override
	public List<List<?>> getBookList(Map param){
		return bookDao.getBookList(param);
	}
	
	@Override
	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}
	
	@Override
	public int insertBook(Book book) {
		return bookDao.insertBook(book);
	}
	
	@Override
	public int updateBook(Book book) {
		return bookDao.updateBook(book);
	}
	
	@Override
	public int delBookById(int id) {
		return bookDao.delBookById(id);
	}
	
	@Override
	public int countBook() {
		return bookDao.countBook();
	}
	
	@Override
	public List<Object> countBookByCategory(){
		return bookDao.countBookByCategory();
	}
	
	@Override
	public int offShelf(Book book) {
		return bookDao.offShelf(book);
	}
	
	
	/******  ÒÆ¶¯¶Ë  *******/
	@Override
	public List<Book> getBookOfPopular(){
		return bookDao.getBookOfPopular();
	}
	

	@Override
	public List<Book> getBookOfNew(){
		return bookDao.getBookOfNew();
	}
	

	@Override
	public List<Book> getBookOfHighBorrow(){
		return bookDao.getBookOfHighBorrow();
	}
	
	@Override
	public List<List<?>> searchBook(Map param){
		return bookDao.searchBook(param);
	}
	
	@Override
	public apiBookDetail getBookDetail(Map<?,?> param) {
		return bookDao.getBookDetail(param);
	}
	
	@Override
	public int borrowBookCallback(int id) {
		return bookDao.borrowBookCallback(id);
	}
	
	@Override
	public int returnBookCallback(List<Integer> ids) {
		return bookDao.returnBookCallback(ids);
	}
}
