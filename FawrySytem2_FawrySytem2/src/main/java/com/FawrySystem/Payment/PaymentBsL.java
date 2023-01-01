package com.FawrySystem.Payment;

import org.springframework.stereotype.Service; 

import com.FawrySystem.Discount.Discount;
import com.FawrySystem.Discount.NewUserDiscount; 
import com.FawrySystem.Discount.OverallDiscount;
import com.FawrySystem.Discount.SpecificDiscount;

@Service
public class PaymentBsL {
	
	private IPayment iPayment;
	private PaymentTransaction paymentTransaction;
	private Discount discount;
	
	public PaymentBsL() {
		discount = new NewUserDiscount();
		paymentTransaction = new PaymentTransaction(); 
	}
	
	
	
	/*{
    "userName": "Salma",
	"serviceName":"school",
	"serviceProvider":"we",
    "paymentMethod":"cash",
	"amount": 10
	}*/

	public boolean pay(PaymentTransaction paymentTransaction) {   
		boolean result = false;
		if (com.FawrySystem.user.UserBsL.getuser(paymentTransaction.getUserName()) != null) { 
			
			if(paymentTransaction.getServiceName().equals("mobile recharge")) {
				
				OverallDiscount overallDiscount = new OverallDiscount(discount);
				 int newamount = overallDiscount.applyDiscount(paymentTransaction.getAmount());
				 paymentTransaction.setAmount(newamount);
				 
				 if (paymentTransaction.getPaymentMethod().equals("cash")) {
					 iPayment = new Cash();
					 result = iPayment.pay(newamount);
				 }
				 else if (paymentTransaction.getPaymentMethod().equals("creditcard")) { 
					 result = com.FawrySystem.user.UserBsL.getuser(paymentTransaction.getUserName()).getCreditCard().pay(newamount);
				 }
				 else if(paymentTransaction.getPaymentMethod().equals("wallet")) {
					 result = com.FawrySystem.user.UserBsL.getuser(paymentTransaction.getUserName()).getWallet().pay(newamount);
				 } 
				 return  result ;  
			}
			else if(paymentTransaction.getServiceName().equals("monthly") ||
			   paymentTransaction.getServiceName().equals("quarter")) {
				
				SpecificDiscount specificDiscount = new SpecificDiscount(discount);
				 int newamount = specificDiscount.applyDiscount(paymentTransaction.getAmount());
				 paymentTransaction.setAmount(newamount);
				 
				 if (paymentTransaction.getPaymentMethod().equals("cash")) {
					 iPayment = new Cash();
					 result = iPayment.pay(paymentTransaction.getAmount());
				 }
				 else if (paymentTransaction.getPaymentMethod().equals("creditcard")) { 
					 result = com.FawrySystem.user.UserBsL.getuser(paymentTransaction.getUserName()).getCreditCard().pay(newamount);
				 }
				 else if(paymentTransaction.getPaymentMethod().equals("wallet")) {
					 result = com.FawrySystem.user.UserBsL.getuser(paymentTransaction.getUserName()).getWallet().pay(newamount);
				 } 
				 return  result ;  
			}
			
			else if(com.FawrySystem.Payment.PaymentTransactionBsL.checkUser(paymentTransaction.getUserName())) {
				NewUserDiscount newUserDiscount = new NewUserDiscount();
				int newamount = newUserDiscount.applyDiscount(paymentTransaction.getAmount());
				 paymentTransaction.setAmount(newamount);
				 
				 if (paymentTransaction.getPaymentMethod().equals("cash")) {
					 iPayment = new Cash();
					 result = iPayment.pay(paymentTransaction.getAmount());
				 }
				 else if (paymentTransaction.getPaymentMethod().equals("creditcard")) { 
					 result = com.FawrySystem.user.UserBsL.getuser(paymentTransaction.getUserName()).getCreditCard().pay(newamount);
				 }
				 else if(paymentTransaction.getPaymentMethod().equals("wallet")) {
					 result = com.FawrySystem.user.UserBsL.getuser(paymentTransaction.getUserName()).getWallet().pay(newamount);
				 } 
				 return  result;  
			}
			
		}
		return result;  
	}
	
}