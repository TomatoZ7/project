package com.cbh.pojo;

public class apiBookList {
	private int id;
	private String book_name;
	private String author;
	private String image;
	
	private String first_cate;
	private String second_cate;
	
	private double score;
	private int collect_count;
	
	public apiBookList() {
		super();
	}

	public apiBookList(int id, String book_name, String author, String image, String first_cate, String second_cate,
			double score, int collect_count) {
		super();
		this.id = id;
		this.book_name = book_name;
		this.author = author;
		this.image = image;
		this.first_cate = first_cate;
		this.second_cate = second_cate;
		this.score = score;
		this.collect_count = collect_count;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
	
	
}
