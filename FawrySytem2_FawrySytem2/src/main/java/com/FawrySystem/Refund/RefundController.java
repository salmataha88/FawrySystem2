package com.FawrySystem.Refund;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefundController {

	private RefundBsL refundBsL;
	
	public RefundController() {
		refundBsL = new RefundBsL();
	}
	
	@PostMapping(value = "/user/refundRequest")
	public String refundRequest(@RequestBody RefundRequest refundRequest) {
		return refundBsL.addRefund(refundRequest); 
	}
	
	@GetMapping(value = "/user/getrefunds")
	public List<RefundRequest>getRefunds(){ 
		return refundBsL.getRefundTransactionList();
	}
	
	@GetMapping(value = "/user/getAcceptedRefunds")
	public List<RefundRequest>getAcceptedRefunds(){
		return refundBsL.getRefundacceptedList();
	} 
}
