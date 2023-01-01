package com.FawrySystem.Services;

import org.springframework.stereotype.Service; 

import com.FawrySystem.Payment.PaymentTransaction;
import com.FawrySystem.Providers.ProviderFactory;
import com.FawrySystem.Providers.ServiceProviders;

@Service
public class ServicesBsL {
	
	private PaymentTransaction paymentTransaction;
	private static Landline landline;
	private static Donation donation;
	private static ServiceFactory serviceFactory;
	private static ServiceProviders serviceProviders;
	private static ProviderFactory providerFactory;
	
	
	public ServicesBsL () {
		paymentTransaction = new PaymentTransaction();
		providerFactory = new ProviderFactory();
		serviceFactory = new ServiceFactory();
		donation = new Donation();
		landline = new Landline();
	}
	public PaymentTransaction getPaymentTransaction() {
		return paymentTransaction;
	}
	public void setPaymentTransaction(PaymentTransaction paymentTransaction) {
		this.paymentTransaction = paymentTransaction;
	}
	public static ServiceFactory getServiceFactory() {
		return serviceFactory;
	}
	public void setServiceFactory(ServiceFactory serviceFactory) {
		ServicesBsL.serviceFactory = serviceFactory;
	}
	public static ServiceProviders getServiceProviders() {
		return serviceProviders; 
	} 
	public void setServiceProviders(ServiceProviders serviceProviders) {
		ServicesBsL.serviceProviders = serviceProviders;
	}
	public static ProviderFactory getProviderFactory() {
		return providerFactory;
	}
	public void setProviderFactory(ProviderFactory providerFactory) {
		ServicesBsL.providerFactory = providerFactory;
	}
	
	public static Landline getLandline() {
		return landline;
	}
	public static void setLandline(Landline landline) {
		ServicesBsL.landline = landline;
	}
	
	public static Donation getDonation() {
		return donation;
	}
	public static void setDonation(Donation donation) {
		ServicesBsL.donation = donation;
	}
	public String getInfoFromTransaction(PaymentTransaction paymentTransaction) {
		if(	(providerFactory.chooseServiceProviders(paymentTransaction.getServiceProvider())!=null ) &&( com.FawrySystem.user.UserBsL.getuser(paymentTransaction.getUserName())!=null) ){
			String ans = serviceFactory.chooseServices(paymentTransaction.getServiceName()).execute(); 
			if(paymentTransaction.getServiceName().equals("monthly") || paymentTransaction.getServiceName().equals("quarter")) {
				return ans +"\n"+landline.setReceipts(paymentTransaction.getServiceName()); 
			}
			else if(paymentTransaction.getServiceName().equals("school") || paymentTransaction.getServiceName().equals("cancer") || paymentTransaction.getServiceName().equals("ngos")) {
				return ans +"\n"+ donation.setDonations(paymentTransaction.getServiceName()); 
			}
			return ans;
		}  
		return "failed..";
	}
	 

}
