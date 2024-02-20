package com.collegemanagementsystem.entities;

public class LoginChek {
	String username,password;

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

	@Override
	public String toString() {
		return "LoginChek [username=" + username + ", password=" + password + "]";
	}

	public LoginChek(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

}
