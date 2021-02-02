package com.cbh.pojo;

public class BookWithComment {
	// borrow_record
	private int id;
	private int book_id;
	private String start_time;
	private String return_time;
	
	// book
	private String book_name;
	private String book_author;
	private String book_image;
	private String book_first_cate;
	
	// comment
	private int comment_id;
	private String comment_content;
	private int comment_score;

	public BookWithComment() {
		super();
	}

	public BookWithComment(int id, int book_id, String start_time, String return_time, String book_name,
			String book_author, String book_image, String book_first_cate, int comment_id, String comment_content,
			int comment_score) {
		super();
		this.id = id;
		this.book_id = book_id;
		this.start_time = start_time;
		this.return_time = return_time;
		this.book_name = book_name;
		this.book_author = book_author;
		this.book_image = book_image;
		this.book_first_cate = book_first_cate;
		this.comment_id = comment_id;
		this.comment_content = comment_content;
		this.comment_score = comment_score;
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

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getReturn_time() {
		return return_time;
	}

	public void setReturn_time(String return_time) {
		this.return_time = return_time;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getBook_image() {
		return book_image;
	}

	public void setBook_image(String book_image) {
		this.book_image = book_image;
	}

	public String getBook_first_cate() {
		return book_first_cate;
	}

	public void setBook_first_cate(String book_first_cate) {
		this.book_first_cate = book_first_cate;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public int getComment_score() {
		return comment_score;
	}

	public void setComment_score(int comment_score) {
		this.comment_score = comment_score;
	}
}
