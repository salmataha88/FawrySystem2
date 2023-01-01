package com.FawrySystem.Payment;

import org.springframework.stereotype.Component;

@Component 
public class AddFunds {
	private String username;
	private int funds; 
	
	public AddFunds() {
		username = " ";
		funds = 0;
	}
	
	public int getFunds() {
		return funds;
	}
	public void setFunds(int funds) {
		this.funds = funds;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String name) { 
		this.username = name;
	}
	
}