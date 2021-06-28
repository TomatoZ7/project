package com.cbh.domain;

public class BorrowRecord {
	private int id;
	private int user_id;
	private int book_id;
	private int status;
	private String start_time;
	private String end_time;
	private String return_time;
	private String create_time;
	
	private User user;
	private Book book;

	public BorrowRecord(int id, int user_id, int book_id, int status, String start_time, String end_time,
			String return_time, String create_time, User user, Book book) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.book_id = book_id;
		this.status = status;
		this.start_time = start_time;
		this.end_time = end_time;
		this.return_time = return_time;
		this.create_time = create_time;
		this.user = user;
		this.book = book;
	}

	public BorrowRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getReturn_time() {
		return return_time;
	}

	public void setReturn_time(String return_time) {
		this.return_time = return_time;
	}
}
