package com.FawrySystem.Discount;

//for mobile 20%
public class SpecificDiscount extends DiscountDecorator {

	public SpecificDiscount(Discount discount) {
		super(discount);
	}
	
	public int applyDiscount(int amount){
		super.applyDiscount(amount);
        return (amount*80)/100; 
	} 

}
