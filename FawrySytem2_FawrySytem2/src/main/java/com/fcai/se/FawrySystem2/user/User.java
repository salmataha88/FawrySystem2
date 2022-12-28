package com.fcai.se.FawrySystem2.user;

import org.springframework.stereotype.Component;

@Component 
public class User {
	private String userName;
	private String email; 
	private String password; 
//	private int balance;
	
	public User() {
		this.userName = " ";
		this.email = " ";
		this.password = " ";
	}
	
	
	public User(String userName, String email, String password) {
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}


//	public int getBalance() {
//		return balance;
//	}
//
//	public void setBalance(int balance) {
//		this.balance = balance;
//	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}