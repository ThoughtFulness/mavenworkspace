package com.aaa.entity;

/**
 * className:User
 * discriptoin:用户实体
 * author:毛宇
 * createTime:2018-11-15 22:03
 */
public class User {

	private int id;
	private String username;
	private String password;
	//盐
	private String password_salt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword_salt() {
		return password_salt;
	}

	public void setPassword_salt(String password_salt) {
		this.password_salt = password_salt;
	}
}
