package com.cbh.pojo;

import java.util.List;

import com.cbh.domain.Category;

public class firstCategory {
	private int id;
	private String category_name;
	private int pid;
	private String create_time;
	
	private List<Category> second_cate;

	public firstCategory(int id, String category_name, int pid, String create_time, List<Category> second_cate) {
		super();
		this.id = id;
		this.category_name = category_name;
		this.pid = pid;
		this.create_time = create_time;
		this.second_cate = second_cate;
	}

	public firstCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public List<Category> getSecond_cate() {
		return second_cate;
	}

	public void setSecond_cate(List<Category> second_cate) {
		this.second_cate = second_cate;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
}
