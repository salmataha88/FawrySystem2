package com.FawrySystem.Providers;

import org.springframework.stereotype.Component;

@Component
public class ProviderFactory {
	
	public ServiceProviders chooseServiceProviders(String provider) {
		
		if(provider.equals("vodafone"))
			return new Vodafone();
		else if(provider.equals("we"))
			return new WE();
		else if(provider.equals("orange"))
			return new Orange();
		else if(provider.equals("etisalat"))
			return new Etisalat();
		
		
		return null;
	}
}
