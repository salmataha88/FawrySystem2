package com.FawrySystem.Services;

import org.springframework.stereotype.Component;

//internetPaymentcontroller??
@Component 
public class InternetPayment implements Services{
	
	private String landline;
	private  int amount;
		
	public String getLandline() {
		return landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String execute() { 
		return "Internet Payment is executed..";
	}

}
