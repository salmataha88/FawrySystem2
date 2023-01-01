package com.FawrySystem.Services;

import org.springframework.stereotype.Component;

//setreceipt
//controller??
//bbasy lmobile nimber ll landline

@Component 
public class Landline implements Services{
	
	private String landline;
	private  int amount;
	private ReceiptServices receiptServices ;
		
	public String getLandline() {
		return landline;
	}

	public void setLandline(String mobile) {
		this.landline = mobile;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}


	@Override
	public String execute() { 
		return "landline is executed..";
		
	}
	
	public String setReceipts(String choice) {
		if(choice.equals("monthly")){
			this.receiptServices = new MonthlyReceipt();
			return this.receiptServices.execute();
		}		
		else if(choice.equals("quarter")) {
			this.receiptServices = new QuarterReceipt();
			return this.receiptServices.execute();
		}
		return null; 
	}
}
