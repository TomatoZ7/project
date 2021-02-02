package com.cbh.pojo;

public class apiBorrowRecordList {
	private int id;
	private int book_id;
	private int status;
	private String start_time;
	private String end_time;
	
	// book
	private String book_name;
	private String book_image;
	private String book_author;
	private String book_first_cate;
	
	public apiBorrowRecordList() {
		super();
	}

	public apiBorrowRecordList(int id, int book_id, int status, String start_time, String end_time, String book_name,
			String book_image, String book_author, String book_first_cate) {
		super();
		this.id = id;
		this.book_id = book_id;
		this.status = status;
		this.start_time = start_time;
		this.end_time = end_time;
		this.book_name = book_name;
		this.book_image = book_image;
		this.book_author = book_author;
		this.book_first_cate = book_first_cate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_image() {
		return book_image;
	}

	public void setBook_image(String book_image) {
		this.book_image = book_image;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getBook_first_cate() {
		return book_first_cate;
	}

	public void setBook_first_cate(String book_first_cate) {
		this.book_first_cate = book_first_cate;
	}
}
