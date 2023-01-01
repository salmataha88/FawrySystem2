package com.FawrySystem.Services;

import org.springframework.stereotype.Component;

//mobileRechargeController??
@Component 
public class MobileRecharge implements Services{
	
	private String mobile;
	private  int amount;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String execute() {
		return "Mobile Service is executed..";
	}

}
