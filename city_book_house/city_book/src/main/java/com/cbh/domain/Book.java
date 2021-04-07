package com.cbh.domain;

import java.util.List;

public class Book {
	private int id;
	private String book_name;
	private String author;
	private int first_category_id;
	private int second_category_id;
	private int total;
	private int stock;
	private String book_code;
	private int status;
	private String place;
	private String introduction;
	private String image;
	private String create_time;
	
	private Integer collect_count;
	private Double score;
	private Integer readCount;
	
	private Integer is_collect;
	private Integer is_borrow;
	
	private Category firstCate;
	private Category secondCate;
	private List<BorrowRecord> borrowRecord;
	
	public Book(int id, String book_name, String author, int first_category_id, int second_category_id, int stock, int total,
			String book_code, int status, String place, String introduction, String image, String create_time) {
		super();
		this.id = id;
		this.book_name = book_name;
		this.author = author;
		this.first_category_id = first_category_id;
		this.second_category_id = second_category_id;
		this.stock = stock;
		this.total = total;
		this.book_code = book_code;
		this.status = status;
		this.place = place;
		this.introduction = introduction;
		this.image = image;
		this.create_time = create_time;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getFirst_category_id() {
		return first_category_id;
	}

	public void setFirst_category_id(int first_category_id) {
		this.first_category_id = first_category_id;
	}

	public int getSecond_category_id() {
		return second_category_id;
	}

	public void setSecond_category_id(int second_category_id) {
		this.second_category_id = second_category_id;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getBook_code() {
		return book_code;
	}

	public void setBook_code(String book_code) {
		this.book_code = book_code;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public Category getFirstCate() {
		return firstCate;
	}

	public void setFirstCate(Category firstCate) {
		this.firstCate = firstCate;
	}

	public Category getSecondCate() {
		return secondCate;
	}

	public void setSecondCate(Category secondCate) {
		this.secondCate = secondCate;
	}

	public List<BorrowRecord> getBorrowRecord() {
		return borrowRecord;
	}

	public void setBorrowRecord(List<BorrowRecord> borrowRecord) {
		this.borrowRecord = borrowRecord;
	}

	public Integer getCollect_count() {
		return collect_count;
	}

	public void setCollect_count(Integer collectCount) {
		this.collect_count = collectCount;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double scoreAvg) {
		this.score = scoreAvg;
	}

	public Integer getIs_collect() {
		return is_collect;
	}

	public void setIs_collect(Integer is_collect) {
		this.is_collect = is_collect;
	}

	public Integer getIs_borrow() {
		return is_borrow;
	}

	public void setIs_borrow(Integer is_borrow) {
		this.is_borrow = is_borrow;
	}

	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}
}
