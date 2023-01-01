package com.FawrySystem.Payment;

import org.springframework.stereotype.Component;

@Component
public class CreditCard  implements IPayment{

	private String expireDate;
	private String CardNumber;
	private int creditAmount ;
	
	
	public CreditCard() {
		expireDate ="";
		CardNumber="";
	}

	public CreditCard(String expireDate, String cardNumber) {
		this.expireDate = expireDate;
		CardNumber = cardNumber;
	}


	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}
	
	public int getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(int creditAmount) {
		this.creditAmount = creditAmount;
	}

	@Override 
	public boolean pay(int Amount) {
		if(Amount <= creditAmount){
			creditAmount -= Amount;
			return true; 
		}
		return false; 
	}
	
}
