package com.apeces.pojo;

public class AppCommList {
	private int id;
	private String content;
	private int score;
	private String create_time;
	
	private int user_id;
	private String user_nickname;
	private String user_avatar;
	
	private int product_id;
	private int product_name;
	private int product_img;
	
	public AppCommList() {
		super();
	}

	public AppCommList(int id, String content, int score, String create_time, int user_id, String user_nickname, String user_avatar,
			int product_id, int product_name, int product_img) {
		super();
		this.id = id;
		this.content = content;
		this.score = score;
		this.create_time = create_time;
		this.user_id = user_id;
		this.user_nickname = user_nickname;
		this.user_avatar = user_avatar;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_img = product_img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getUser_avatar() {
		return user_avatar;
	}

	public void setUser_avatar(String user_avatar) {
		this.user_avatar = user_avatar;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getProduct_name() {
		return product_name;
	}

	public void setProduct_name(int product_name) {
		this.product_name = product_name;
	}

	public int getProduct_img() {
		return product_img;
	}

	public void setProduct_img(int product_img) {
		this.product_img = product_img;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	
	
}
