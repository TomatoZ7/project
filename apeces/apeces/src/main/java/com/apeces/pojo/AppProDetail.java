package com.apeces.pojo;

public class AppProDetail {
	private int id;
	private String name;
	private double price;
	private String unit;
	private String cover_img;
	private String introduction;
	private String detail_img;
	private int nums;
	
	private int category_id;
	private String category_name;
	
	private int shop_id;
	private String shop_name;
	private String shop_logo;
	
	public AppProDetail() {
		super();
	}

	public AppProDetail(int id, String name, double price, String unit, String cover_img, String introduction,
			String detail_img, int nums, int category_id, String category_name, int shop_id, String shop_name,
			String shop_logo) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.unit = unit;
		this.cover_img = cover_img;
		this.introduction = introduction;
		this.detail_img = detail_img;
		this.nums = nums;
		this.category_id = category_id;
		this.category_name = category_name;
		this.shop_id = shop_id;
		this.shop_name = shop_name;
		this.shop_logo = shop_logo;
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

	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public int getShop_id() {
		return shop_id;
	}

	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public String getShop_logo() {
		return shop_logo;
	}

	public void setShop_logo(String shop_logo) {
		this.shop_logo = shop_logo;
	}
	
	
}
