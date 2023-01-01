package com.FawrySystem.Services;

import org.springframework.stereotype.Component;


//donation controller??
@Component 
public class Donation implements Services {
	
	private String place;
	private  int amount;
	private static DonationServices donationServices ;
	
		
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	

	@Override
	public String execute() {
		return "Donation services are executed.."; 
	}

	public static DonationServices getDonationServices() {
		return donationServices;
	}

	public void setDonationServices(DonationServices donationServices) {
		this.donationServices = donationServices; 
	}
	
	public String setDonations(String donation) {
		if(donation.equalsIgnoreCase("school")) {
			donationServices = new Schools();
			return donationServices.execute(); 
		}
		else if(donation.equals("ngos")) { 
			this.donationServices = new NGOS();
			return this.donationServices.execute();
		}
		else if(donation.equals("cancer")) {
			this.donationServices = new Cancer();	
			return this.donationServices.execute();
		}
		return null; 
	}

}
