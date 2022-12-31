package com.FawrySystem.Discount;


public class DiscountDecorator implements Discount {

	private Discount discount;

	 public DiscountDecorator(Discount discount) {
		 this.discount = discount;
     }

	@Override
	public int applyDiscount(int amount) {
		return this.discount.applyDiscount(amount);
	}
	 
	

	
}
