package com.apeces.domain;

import com.apeces.pojo.ProSimple;

public class News {
	private int id;
	private String title;
	private String cover_img;
	private String content;
	private String create_time;
	private int product_id;
	private int shop_id;
	
	private ProSimple product;
	
	public News() {
		super();
	}

	public News(int id, String title, String cover_img, String content, String create_time, int product_id,
			int shop_id) {
		super();
		this.id = id;
		this.title = title;
		this.cover_img = cover_img;
		this.content = content;
		this.create_time = create_time;
		this.product_id = product_id;
		this.shop_id = shop_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCover_img() {
		return cover_img;
	}

	public void setCover_img(String cover_img) {
		this.cover_img = cover_img;
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

	public ProSimple getProduct() {
		return product;
	}

	public void setProduct(ProSimple product) {
		this.product = product;
	}
	
	
}
