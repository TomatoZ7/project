package com.cbh.pojo;

public class apiBookDetail {
	private int id;
	private String book_name;
	private String author;
	private String first_cate;
	private String second_cate;
	private String place;
	private String book_code;
	private int stock;
	private String introduction;
	private String image;
	
	private double score;
	private int collect_count;
	
	private int is_collect;
	private int is_borrow;
	
	public apiBookDetail() {
		super();
	}

	public apiBookDetail(int id, String book_name, String author, String first_cate, String second_cate, String place,
			String book_code, int stock, String introduction, String image, double score, int collect_count,
			int is_collect, int is_borrow) {
		super();
		this.id = id;
		this.book_name = book_name;
		this.author = author;
		this.first_cate = first_cate;
		this.second_cate = second_cate;
		this.place = place;
		this.book_code = book_code;
		this.stock = stock;
		this.introduction = introduction;
		this.image = image;
		this.score = score;
		this.collect_count = collect_count;
		this.is_collect = is_collect;
		this.is_borrow = is_borrow;
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

	public String getFirst_cate() {
		return first_cate;
	}

	public void setFirst_cate(String first_cate) {
		this.first_cate = first_cate;
	}

	public String getSecond_cate() {
		return second_cate;
	}

	public void setSecond_cate(String second_cate) {
		this.second_cate = second_cate;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getBook_code() {
		return book_code;
	}

	public void setBook_code(String book_code) {
		this.book_code = book_code;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getCollect_count() {
		return collect_count;
	}

	public void setCollect_count(int collect_count) {
		this.collect_count = collect_count;
	}

	public int getIs_collect() {
		return is_collect;
	}

	public void setIs_collect(int is_collect) {
		this.is_collect = is_collect;
	}

	public int getIs_borrow() {
		return is_borrow;
	}

	public void setIs_borrow(int is_borrow) {
		this.is_borrow = is_borrow;
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
}
