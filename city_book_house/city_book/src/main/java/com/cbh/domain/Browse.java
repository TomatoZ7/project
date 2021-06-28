package com.cbh.domain;

public class Browse {
	private int id;
	private int user_id;
	private int book_id;
	private String time;

	// book
	private String book_name;
	private String book_image;
	private String book_author;
	private String book_stock;
	private String book_first_cate;
	private String book_second_cate;

	public Browse() {
		super();
	}

	public Browse(int id, int user_id, int book_id, String time, String book_name, String book_image,
			String book_author, String book_stock, String book_first_cate, String book_second_cate) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.book_id = book_id;
		this.time = time;
		this.book_name = book_name;
		this.book_image = book_image;
		this.book_author = book_author;
		this.book_stock = book_stock;
		this.book_first_cate = book_first_cate;
		this.book_second_cate = book_second_cate;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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

	public String getBook_stock() {
		return book_stock;
	}

	public void setBook_stock(String book_stock) {
		this.book_stock = book_stock;
	}

	public String getBook_first_cate() {
		return book_first_cate;
	}

	public void setBook_first_cate(String book_first_cate) {
		this.book_first_cate = book_first_cate;
	}

	public String getBook_second_cate() {
		return book_second_cate;
	}

	public void setBook_second_cate(String second_first_cate) {
		this.book_second_cate = second_first_cate;
	}
}
