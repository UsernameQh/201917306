package com.entity;

public class TypeBook {
	@Override
	public String toString() {
		return id+"¡¢"+typebook;
	}
	private String id;
	private String typebook;
	private String desc;
	
	public TypeBook(String id, String typebook, String desc) {
		super();
		this.id = id;
		this.typebook = typebook;
		this.desc = desc;
	}
	public TypeBook() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTypebook() {
		return typebook;
	}
	public void setTypebook(String typebook) {
		this.typebook = typebook;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
