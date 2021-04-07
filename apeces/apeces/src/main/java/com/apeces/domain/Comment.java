package com.apeces.domain;

import com.apeces.pojo.ProSimple;

public class Comment {
	private int id;
	private String content;
	private int score;
	private int user_id;
	private int product_id;
	private int shop_id;
	private int order_id;
	private String create_time;
	
	private ProSimple product;
	
	private String user_nickname;
	private String user_avatar;
	
	private String product_name;
	private String product_img;
	
	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_img() {
		return product_img;
	}

	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}

	public Comment() {
		super();
	}

	public Comment(int id, String content, int score, int user_id, int product_id, int shop_id, int order_id,
			String create_time) {
		super();
		this.id = id;
		this.content = content;
		this.score = score;
		this.user_id = user_id;
		this.product_id = product_id;
		this.shop_id = shop_id;
		this.order_id = order_id;
		this.create_time = create_time;
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

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getShop_id() {
		return shop_id;
	}

	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public ProSimple getProduct() {
		return product;
	}

	public void setProduct(ProSimple product) {
		this.product = product;
	}

	public String getUser_avatar() {
		return user_avatar;
	}

	public void setUser_avatar(String user_avatar) {
		this.user_avatar = user_avatar;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
}
