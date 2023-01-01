package com.FawrySystem.Refund;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.ansi.Ansi8BitColor;
import org.springframework.stereotype.Service;

import com.FawrySystem.Payment.Wallet;
 
@Service
public class RefundBsL {
	
	private List<RefundRequest>refundTransactionList;
	private List<RefundRequest>refundacceptedList;

	
	public RefundBsL() { 
		refundTransactionList = new ArrayList<>();
		refundacceptedList = new ArrayList<>();
	}
	
	public RefundBsL(List<RefundRequest> refundTransactionList, List<RefundRequest> refundacceptedList) {
		this.refundTransactionList = refundTransactionList;
		this.refundacceptedList = refundacceptedList;
	}
	
	public List<RefundRequest> getRefundTransactionList() {
		return refundTransactionList;
	}

	public void setRefundTransactionList(List<RefundRequest> refundTransactionList) {
		this.refundTransactionList = refundTransactionList;
	}

	public List<RefundRequest> getRefundacceptedList() {
		return refundacceptedList;
	}

	public void setRefundacceptedList(List<RefundRequest> refundacceptedList) {
		this.refundacceptedList = refundacceptedList;
	}


	public String addRefund(RefundRequest refundRequest) {
		if (com.FawrySystem.user.UserBsL.getuser(refundRequest.getUsername()) != null) { //pay
			if(refundRequest.getWithDays()<0) {
				return "These days not accepted..";
			}
			else {
				refundTransactionList.add(refundRequest);
				if(refundRequest.getWithDays() <= 14 && refundRequest.getWithDays()>-1) {
					refundacceptedList.add(refundRequest);
					com.FawrySystem.user.UserBsL.getuser(refundRequest.getUsername()).getWallet().addFunds(refundRequest.getAmount());
					return "Refund accepted.."+ "\nYour balance becomes " +  com.FawrySystem.user.UserBsL.getuser(refundRequest.getUsername()).getWallet().getBalance();
				}
				return "Refund not accepted.."; 
			}
		}
		return "failed..";
	} 
	
	

}
