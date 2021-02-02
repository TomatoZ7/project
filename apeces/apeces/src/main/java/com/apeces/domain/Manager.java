package com.apeces.domain;

public class Manager {
	private int id;
	private String phone;
	private String password;
	private int shop_id;
	
	private Shop shop;
	
	public Manager(int id, String phone, String password, int shop_id) {
		super();
		this.id = id;
		this.phone = phone;
		this.password = password;
		this.shop_id = shop_id;
	}

	public Manager() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getShop_id() {
		return shop_id;
	}

	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	
}
