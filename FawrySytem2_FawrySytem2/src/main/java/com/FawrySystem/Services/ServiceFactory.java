package com.FawrySystem.Services;

import org.springframework.stereotype.Component;

@Component
public class ServiceFactory {
	
	public  Services chooseServices(String Service) {
		
		if(Service.equals("mobile recharge"))
			return new MobileRecharge(); 
		else if(Service.equals("internet payment"))
			return new InternetPayment();
		else if(Service.equals("landline") || Service.equals("monthly") ||Service.equals("quarter") )
			return new Landline();    
		else if(Service.equals("donation") || Service.equals("school") || Service.equals("cancer")||Service.equals("ngos"))
			return new Donation();
		
		return null;
	}

}
