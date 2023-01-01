package com.FawrySystem.Payment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AddFundBsL {
	private List<AddFunds> Fundslist;
	
	public AddFundBsL() {
		Fundslist = new ArrayList<>();
	}
	
	public AddFundBsL(List<AddFunds> fundslist) {
		Fundslist = fundslist;
	} 
	 
	public List<AddFunds> getFundslist() {
		return Fundslist;
	}
	public void setFundslist(List<AddFunds> fundslist) {
		Fundslist = fundslist;
	} 
	
	public String addfunds(AddFunds addFunds) { //credit info wallet add to funds 
		if (com.FawrySystem.user.UserBsL.getuser(addFunds.getUsername()) != null) {
			int newBalance = com.FawrySystem.user.UserBsL.getuser(addFunds.getUsername()).getWallet().getBalance() + addFunds.getFunds();
			int newcreditBalance = 	com.FawrySystem.user.UserBsL.getuser(addFunds.getUsername()).getCreditCard().getCreditAmount() - addFunds.getFunds();
			if(newcreditBalance > 0) {
			com.FawrySystem.user.UserBsL.getuser(addFunds.getUsername()).getCreditCard().setCreditAmount(newcreditBalance);
			com.FawrySystem.user.UserBsL.getuser(addFunds.getUsername()).getWallet().setBalance(newBalance);
			Fundslist.add(addFunds);
			return"Your Balance becomes " + com.FawrySystem.user.UserBsL.getuser(addFunds.getUsername()).getWallet().getBalance(); 
			}
			else return "Not enough CreditBalance..";
		}
		return "Failed"; 
	} 
}