package com.cbh.domain;

import java.util.List;

public class User {
	private int id;
	private String code;
	private String account;
	private String name;
	private int gender;
	private String phone;
	private String password;
	private int status;
	private int auth;
	private int manager_id;
	private String avatar;
	
	private List<BorrowRecord> borrow_record;
	private List<Book> book;
	private Integer collectCount;	//  ’≤ÿ¡ø
	private Integer borrow_num;
	
	public User(int id, String code, String name, int gender, String phone, int status, int auth, String id_num,
			String apply_time, String id_positive_img, String id_negative_img, int apply_status, String verify_remark) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.status = status;
		this.auth = auth;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public List<BorrowRecord> getBorrow_record() {
		return borrow_record;
	}

	public void setBorrow_record(List<BorrowRecord> borrow_record) {
		this.borrow_record = borrow_record;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public Integer getCollectCount() {
		return collectCount;
	}

	public void setCollectCount(Integer collectCount) {
		this.collectCount = collectCount;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getBorrow_num() {
		return borrow_num;
	}

	public void setBorrow_num(Integer borrow_num) {
		this.borrow_num = borrow_num;
	}
}
