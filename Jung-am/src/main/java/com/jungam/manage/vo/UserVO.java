package com.jungam.manage.vo;

public class UserVO {
	private String id;
	private String password;
	private String name;
	private String email;
	private String phone;
	private int level;
	private String lastDate;
	
	
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public int getLevel() {
		return level;
	}
	public String getLastDate() {
		return lastDate;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
}
