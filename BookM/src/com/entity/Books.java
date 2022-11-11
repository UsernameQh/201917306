package com.entity;

public class Books {
	int booksID;
	String bookname;
	String zuozhe;
	String zuozhexb;
	float jiage;
	Integer bookID;
	String bookdesc;
	public String getBookdesc() {
		return bookdesc;
	}
	public void setBookdesc(String bookdesc) {
		this.bookdesc = bookdesc;
	}
	public int getBooksID() {
		return booksID;
	}
	public void setBooksID(int booksID) {
		this.booksID = booksID;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getZuozhe() {
		return zuozhe;
	}
	public void setZuozhe(String zuozhe) {
		this.zuozhe = zuozhe;
	}
	public String getZuozhexb() {
		return zuozhexb;
	}
	public void setZuozhexb(String zuozhexb) {
		this.zuozhexb = zuozhexb;
	}
	public float getJiage() {
		return jiage;
	}
	public void setJiage(float jiage) {
		this.jiage = jiage;
	}
	public Integer getBookID() {
		return bookID;
	}
	public void setBookID(Integer bookID) {
		this.bookID = bookID;
	}
	public Books() {
		
	}
	public Books(int booksID, String bookname, String zuozhe, String zuozhexb, float jiage, Integer bookID,
			String bookdesc) {
		super();
		this.booksID = booksID;
		this.bookname = bookname;
		this.zuozhe = zuozhe;
		this.zuozhexb = zuozhexb;
		this.jiage = jiage;
		this.bookID = bookID;
		this.bookdesc = bookdesc;
	}
	public Books(String bookname, String zuozhe, String zuozhexb, float jiage, int bookID, String bookdesc) {
		super();
		this.bookname = bookname;
		this.zuozhe = zuozhe;
		this.zuozhexb = zuozhexb;
		this.jiage = jiage;
		this.bookID = bookID;
		this.bookdesc = bookdesc;
	}
}
