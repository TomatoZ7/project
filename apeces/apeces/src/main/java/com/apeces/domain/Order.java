package com.apeces.domain;

import com.apeces.pojo.ProSimple;

public class Order {
	private int id;
	private String order_no;
	private int user_id;
	private int product_id;
	private int shop_id;
	private int address_id;
	private int nums;
	private double amount;
	private int status;
	private String create_time;
	
	private ProSimple product;
	private Address address;
	
	public Order() {
		super();
	}

	public Order(int id, String order_no, int user_id, int product_id, int shop_id, int address_id, int nums,
			double amount, int status, String create_time) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.user_id = user_id;
		this.product_id = product_id;
		this.shop_id = shop_id;
		this.address_id = address_id;
		this.nums = nums;
		this.amount = amount;
		this.status = status;
		this.create_time = create_time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
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

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
