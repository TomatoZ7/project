package com.apeces.domain;

public class Address {
	private int id;
	private String phone;
	private String name;
	private String address;
	private int user_id;
	
	public Address() {
		super();
	}

	public Address(int id, String phone, String name, String address, int user_id) {
		super();
		this.id = id;
		this.phone = phone;
		this.name = name;
		this.address = address;
		this.setUser_id(user_id);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
}
