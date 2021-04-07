package com.cbh.dao;

import java.util.List;
import java.util.Map;

import com.cbh.domain.Book;
import com.cbh.domain.Comment;
import com.cbh.pojo.BookWithComment;
import com.cbh.pojo.apiBookDetail;

public interface BookDao {
	List<List<?>> getBookList(Map<?,?> param);
	
	Book getBookById(int id);
	
	int insertBook(Book book);
	
	int updateBook(Book book);
	
	int delBookById(int id);
	
	int countBook();
	
	List<Object> countBookByCategory(); 
	
	int offShelf(Book book);
	
	
	/******  ÒÆ¶¯¶Ë  *******/
	List<Book> getBookOfPopular();

	List<Book> getBookOfNew();
	
	List<Book> getBookOfHighBorrow();
	
	List<List<?>> searchBook(Map<?,?> param);
	
	apiBookDetail getBookDetail(Map<?,?> param);
	
	int borrowBookCallback(int id);
	
	int returnBookCallback(List<Integer> ids);
}
