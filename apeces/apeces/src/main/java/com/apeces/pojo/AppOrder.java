package com.apeces.pojo;

public class AppOrder {
	private int id;
	private String order_no;
	private int nums;
	private double amount;
	private int status;
	
	private int product_id;
	private String product_name;
	private String product_cover_img;

	private int shop_id;
	private String shop_name;
	private String shop_phone;
	
	private int address_id;
	private String address_name;
	private String address_phone;
	private String address;
	
	public AppOrder() {
		super();
	}

	public AppOrder(int id, String order_no, int nums, double amount, int status, int product_id, String product_name,
			String product_cover_img, int shop_id, String shop_name, String shop_phone, int address_id, String address_name,
			String address_phone, String address) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.nums = nums;
		this.amount = amount;
		this.status = status;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_cover_img = product_cover_img;
		this.shop_id = shop_id;
		this.shop_name = shop_name;
		this.setShop_phone(shop_phone);
		this.address_id = address_id;
		this.address_name = address_name;
		this.address_phone = address_phone;
		this.address = address;
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

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_cover_img() {
		return product_cover_img;
	}

	public void setProduct_cover_img(String product_cover_img) {
		this.product_cover_img = product_cover_img;
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

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getAddress_name() {
		return address_name;
	}

	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}

	public String getAddress_phone() {
		return address_phone;
	}

	public void setAddress_phone(String address_phone) {
		this.address_phone = address_phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getShop_phone() {
		return shop_phone;
	}

	public void setShop_phone(String shop_phone) {
		this.shop_phone = shop_phone;
	}
	
	
}
