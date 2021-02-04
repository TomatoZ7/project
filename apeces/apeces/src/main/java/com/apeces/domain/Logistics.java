package com.apeces.domain;

public class Logistics {
	private int id;
	private int order_id;
	private String info;
	private String create_time;
	
	public Logistics() {
		super();
	}

	public Logistics(int id, int order_id, String info, String create_time) {
		super();
		this.id = id;
		this.order_id = order_id;
		this.info = info;
		this.create_time = create_time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
}
