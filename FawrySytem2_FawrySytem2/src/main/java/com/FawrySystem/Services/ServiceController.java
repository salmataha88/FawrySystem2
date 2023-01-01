package com.FawrySystem.Services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.FawrySystem.Payment.PaymentTransaction; 
import com.FawrySystem.Payment.PaymentTransactionBsL;

@RestController 
public class ServiceController { 
	
	private ServicesBsL servicesBsL;
	private PaymentTransactionBsL paymentTransactionBsL;
	
	public ServiceController() {
		servicesBsL = new ServicesBsL();
		paymentTransactionBsL = new PaymentTransactionBsL();
	}

	@PostMapping(value = "/user/services")
	public String chooseservices(@RequestBody PaymentTransaction paymentTransaction) { 
		return servicesBsL.getInfoFromTransaction(paymentTransaction); 
		
	}
	
	@PostMapping(value = "/user/addTransaction")
	public String addTransaction(@RequestBody PaymentTransaction paymentTransaction) {
		return paymentTransactionBsL.addTransaction(paymentTransaction);  
	} 
	
	
	@GetMapping(value = "/user/getTransactions")
	public List<PaymentTransaction> getTransactions() { 
		return paymentTransactionBsL.getPaymentTransactionsList(); 
	} 
	

}
