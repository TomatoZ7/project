package com.apeces.domain;

public class Product {
	private int id;
	private String name;
	private double price;
	private String unit;
	private int category_id;
	private String cover_img;
	private String introduction;
	private String detail_img;
	private int shop_id;
	private int nums;
	
	public Product() {
		super();
	}

	public Product(int id, String name, double price, String unit, int category_id, String cover_img,
			String introduction, String detail_img, int shop_id, int nums) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.unit = unit;
		this.category_id = category_id;
		this.cover_img = cover_img;
		this.introduction = introduction;
		this.detail_img = detail_img;
		this.shop_id = shop_id;
		this.nums = nums;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCover_img() {
		return cover_img;
	}

	public void setCover_img(String cover_img) {
		this.cover_img = cover_img;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getDetail_img() {
		return detail_img;
	}

	public void setDetail_img(String detail_img) {
		this.detail_img = detail_img;
	}

	public int getShop_id() {
		return shop_id;
	}

	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}

	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}
	
	
}
