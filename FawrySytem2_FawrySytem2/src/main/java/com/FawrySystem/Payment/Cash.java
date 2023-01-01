package com.FawrySystem.Payment;

import org.springframework.stereotype.Component;

@Component
public class Cash implements IPayment{ 
	
	@Override
	public boolean pay(int Amount) {
		return true; 
	}
	
}
