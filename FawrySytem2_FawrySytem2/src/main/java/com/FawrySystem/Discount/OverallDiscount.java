package com.FawrySystem.Discount;

//donation 15%
public class OverallDiscount extends DiscountDecorator{
	

	public OverallDiscount(Discount discount) {
		super(discount);
	}
	
	@Override
    public int applyDiscount(int Price) {
        return (Price*85)/100;   
    } 

}
