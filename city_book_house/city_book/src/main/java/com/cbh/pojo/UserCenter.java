package com.cbh.pojo;

public class UserCenter {
	private int id;
	private String avatar;
	private String code;
	private int auth;
	private String name;
	private int manager_id;
	
	private int apply_status;
	
	private int balance;

	public UserCenter(int id, String avatar, String code, int auth, String name, int manager_id, int apply_status,
			int balance) {
		super();
		this.id = id;
		this.avatar = avatar;
		this.code = code;
		this.auth = auth;
		this.name = name;
		this.manager_id = manager_id;
		this.apply_status = apply_status;
		this.balance = balance;
	}

	public UserCenter() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public int getApply_status() {
		return apply_status;
	}

	public void setApply_status(int apply_status) {
		this.apply_status = apply_status;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
