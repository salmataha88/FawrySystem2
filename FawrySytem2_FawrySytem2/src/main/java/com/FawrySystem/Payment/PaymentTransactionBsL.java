package com.FawrySystem.Payment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.FawrySystem.Discount.Discount;
import com.FawrySystem.Discount.DiscountDecorator;
import com.FawrySystem.Discount.NewUserDiscount;
import com.FawrySystem.Discount.OverallDiscount;
import com.FawrySystem.user.User;

@Service
public class PaymentTransactionBsL {
	
	private static List<PaymentTransaction>paymentTransactionsList;
	private PaymentBsL paymentBsL;
	
	public PaymentTransactionBsL() {
		paymentTransactionsList = new ArrayList<>();
		paymentBsL = new PaymentBsL();
	}

	public PaymentTransactionBsL(List<PaymentTransaction> paymentTransactionsList) {
		this.paymentTransactionsList = paymentTransactionsList;
	}

	public List<PaymentTransaction> getPaymentTransactionsList() {
		return paymentTransactionsList; 
	}

	public void setPaymentTransactionsList(List<PaymentTransaction> paymentTransactionsList) {
		this.paymentTransactionsList = paymentTransactionsList;
	}
	
	public String addTransaction(PaymentTransaction paymentTransaction) { 
		
		if (com.FawrySystem.user.UserBsL.getuser(paymentTransaction.getUserName()) != null) {
			if(paymentBsL.pay(paymentTransaction)) { 
				paymentTransactionsList.add(paymentTransaction);
				return "Transaction added successfully.."; 
			}
			else return"Pay method failed.."; 
		}
		return "Failed.. \n There is no user with this username..";  
	} 
	
	public static boolean checkUser(String username) { 
		for (PaymentTransaction iuser : paymentTransactionsList) {
			if(iuser.getUserName().equals(username)) {
				return true; 
			}
		}
		return false;
	}

}
