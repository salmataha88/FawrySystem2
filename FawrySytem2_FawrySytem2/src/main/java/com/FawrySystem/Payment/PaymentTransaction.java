package com.FawrySystem.Payment;

import org.springframework.stereotype.Component;

//list --> username - payment method - amount

@Component 
public class PaymentTransaction { 
	
	private String userName;
	static private  String serviceName;
	private String serviceProvider;
	private String mobileNumber;
	private String paymentMethod;
	private int amount; //check if there is discount or not? 
	
	
	public PaymentTransaction() {
		userName = " ";
		serviceName = " ";
		serviceProvider = " ";
		mobileNumber =" ";
		paymentMethod=" ";
		amount = 0;
	}

	public PaymentTransaction(String userName,String serviceName, String serviceProvider,String mobileNumber, String paymentMethod, int amount) {
		this.userName = userName;
		PaymentTransaction.serviceName = serviceName;
		this.serviceProvider = serviceProvider;
		this.mobileNumber = mobileNumber;
		this.paymentMethod = paymentMethod;
		this.amount = amount;
	}

	public  String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	static public String getServiceName() { 
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		PaymentTransaction.serviceName = serviceName;
	}

	public String getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
	
	
}
