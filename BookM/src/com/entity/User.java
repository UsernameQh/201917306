package com.entity;

public class User {
	private int ID;
	private String UserName;
	private String PassWord;
	
	public User(String userName, String passWord) {
		super();
		this.UserName = userName;
		this.PassWord = passWord;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public int getID() {
		return this.ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	public String getUserName() {
		return this.UserName;
	}
	public void setUserName(String userName) {
		this.UserName = userName;
	}
	public String getPassWord() {
		return this.PassWord;
	}
	public void setPassWord(String passWord) {
		this.PassWord = passWord;
	}
	
}