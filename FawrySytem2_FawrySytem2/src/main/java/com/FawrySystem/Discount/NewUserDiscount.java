package com.FawrySystem.Discount;

//for new user 10%
public class NewUserDiscount implements Discount{

	@Override
	public int applyDiscount(int amount){ 
		 return (amount*90)/100; 
	}
	//discount--> precent return amount 

}
