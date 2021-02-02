package com.cbh.domain;

public class Comment {
	private Integer id;
	private Integer book_id;
	private Integer user_id;
	private Integer score;
	private String content;
	private String create_time;
	
	// user
	private String user_avatar;
	private String user_name;
	
	public Comment(Integer id, Integer book_id, Integer user_id, Integer score, String content, String create_time,
			User user, Book book) {
		super();
		this.id = id;
		this.book_id = book_id;
		this.user_id = user_id;
		this.score = score;
		this.content = content;
		this.create_time = create_time;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUser_avatar() {
		return user_avatar;
	}

	public void setUser_avatar(String user_avatar) {
		this.user_avatar = user_avatar;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	
}
