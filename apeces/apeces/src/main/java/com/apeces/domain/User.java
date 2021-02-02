package com.apeces.domain;

public class User {
	private int id;
	private String phone;
	private String password;
	private String nickname;
	private String avatar;
	
	public User(int id, String phone, String password, String nickname, String avatar) {
		super();
		this.id = id;
		this.phone = phone;
		this.password = password;
		this.nickname = nickname;
		this.avatar = avatar;
	}

	public User() {
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	
}
