package com.apeces.domain;

public class Address {
	private int id;
	private String phone;
	private String name;
	private String address;
	
	public Address() {
		super();
	}

	public Address(int id, String phone, String name, String address) {
		super();
		this.id = id;
		this.phone = phone;
		this.name = name;
		this.address = address;
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
	
	
}
