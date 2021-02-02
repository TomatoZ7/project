package com.cbh.domain;

public class UserApply {
	private int id;
	private int user_id;
	private String name;
	private int gender;
	private String phone;
	private String id_card;
	private String id_card_positive_img;
	private String id_card_negative_img;
	private int status;
	private String remark;
	private String create_time;
	
	private User user;
	
	public UserApply(int id, int user_id, String id_card, String id_card_positive_img, String id_card_negative_img,
			int status, String remark, String create_time) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.id_card = id_card;
		this.id_card_positive_img = id_card_positive_img;
		this.id_card_negative_img = id_card_negative_img;
		this.status = status;
		this.remark = remark;
		this.create_time = create_time;
	}

	public UserApply() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getId_card() {
		return id_card;
	}

	public void setId_card(String id_card) {
		this.id_card = id_card;
	}

	public String getId_card_positive_img() {
		return id_card_positive_img;
	}

	public void setId_card_positive_img(String id_card_positive_img) {
		this.id_card_positive_img = id_card_positive_img;
	}

	public String getId_card_negative_img() {
		return id_card_negative_img;
	}

	public void setId_card_negative_img(String id_card_negative_img) {
		this.id_card_negative_img = id_card_negative_img;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
