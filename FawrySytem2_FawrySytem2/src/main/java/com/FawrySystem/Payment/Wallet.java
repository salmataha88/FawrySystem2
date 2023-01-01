package com.FawrySystem.Payment;

import org.springframework.stereotype.Component;

@Component 
public class Wallet implements IPayment{
	
	 static private int newbalance = 0; 
	 private int balance = 0;//
	
	public void setBalance(int balance) {
		this.balance =  balance;
	}
	
	 public int getBalance() {
		return balance; 
	}
	 
	static public int getNewbalance() {
		return newbalance;
	}

	public void setNewbalance(int newbalance) {
		this.newbalance = newbalance;  
	}

	public void addFunds(int funds) {         
		setNewbalance(newbalance + funds);
		setBalance(getNewbalance()); 
	}

	@Override 
	public boolean pay(int Amount) {
		if(Amount <= balance) {
			setBalance(balance-Amount);
			return true;
		}
		return false;  
	}
	
}
