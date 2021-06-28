package com.apeces.pojo;

public class appProList {
	private int id;
	private String name;
	private String cover_img;
	private Double price;
	
	public appProList() {
		super();
	}

	public appProList(int id, String name, String cover_img, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.cover_img = cover_img;
		this.price = price;
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

	public String getCover_img() {
		return cover_img;
	}

	public void setCover_img(String cover_img) {
		this.cover_img = cover_img;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
