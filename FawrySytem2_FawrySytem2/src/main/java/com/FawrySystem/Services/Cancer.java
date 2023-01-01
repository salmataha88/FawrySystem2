package com.FawrySystem.Services;

import org.springframework.stereotype.Component; 

@Component
public class Cancer implements DonationServices{
	
	@Override
	public String execute() {
		return "Cancer is executed..";
	}
	

}
