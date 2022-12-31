package com.FawrySystem.user;

import org.springframework.stereotype.Component;

import com.FawrySystem.Payment.CreditCard;
import com.FawrySystem.Payment.Wallet;

@Component 
public class User {
	private String userName;
	private String email; 
	private String password; 
	static private int funds ;
	static private Wallet wallet;
	 private CreditCard creditCard;

	public User() { 
		this.userName = " ";
		this.email = " ";
		this.password = " ";
		this.wallet = new Wallet();
		this.creditCard = new CreditCard();
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

	public User(CreditCard card , String username) {
		userName = username;
		creditCard = card;
	}
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

	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public  CreditCard getCreditCard() {
		return creditCard;
	}

	public  void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
	
}