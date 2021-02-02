package com.apeces.domain;

public class Shop {
	private int id;
	private String name;
	private String phone;
	private String logo;
	private String introduction;
	
	public Shop() {
		super();
	}

	public Shop(int id, String name, String phone, String logo, String introduction) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.logo = logo;
		this.introduction = introduction;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	
}
