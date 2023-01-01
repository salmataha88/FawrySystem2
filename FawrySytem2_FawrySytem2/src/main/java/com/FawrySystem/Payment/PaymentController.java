package com.FawrySystem.Payment;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
	
	private PaymentBsL paymentBsL;

	public PaymentController(PaymentBsL paymentBsL) {
		this.paymentBsL = paymentBsL;
	}
	
	@PostMapping(value = "/user/pay")
	public boolean pay(@RequestBody PaymentTransaction paymentTransaction) {
		return paymentBsL.pay(paymentTransaction);  
	}
	
	
	

}
