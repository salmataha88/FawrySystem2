package com.FawrySystem.Refund;

import org.springframework.stereotype.Component;

@Component
public class RefundRequest {
	
	private String username;
	private String servicename;
	private int amount;
	private int withDays;
	
	public RefundRequest() {
		username = " ";
		servicename = " ";
		amount = 0;
		withDays = 0;
	}

	public RefundRequest(String username, String servicename, int amount , int withDays) {
		this.username = username;
		this.servicename = servicename;
		this.amount = amount;
		this.withDays = withDays;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getServicename() {
		return servicename;
	}
	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getWithDays() {
		return withDays;
	}

	public void setWithDays(int withDays) {
		this.withDays = withDays;
	}

	
	
	
}
