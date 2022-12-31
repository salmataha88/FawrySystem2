package com.FawrySystem.user;

import java.util.List; 

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.FawrySystem.Payment.AddFundBsL;
import com.FawrySystem.Payment.AddFunds;
import com.FawrySystem.Payment.CreditCard;
import com.FawrySystem.Payment.PaymentTransaction;


@RestController 
public class UserController {
	private UserBsL userBsL;  
	private AddFundBsL addFundBsL;

	public UserController(UserBsL userBsL) {
		this.userBsL = userBsL;
		addFundBsL = new AddFundBsL();
	}

	@RequestMapping(value = "/user/signup" , method = RequestMethod.POST)
	public String adduser(@RequestBody User user) {
		return userBsL.add(user);  
	}
	
	@GetMapping(value = "/user/{username}")
	public User getuser(@PathVariable("username") String username) {
		return userBsL.getuser(username); 
	}
	
	@PostMapping(value = "/user/signin")
	public String Finduser(@RequestBody User user) {
		return userBsL.Signin(user); 
	}
	
	@PostMapping(value = "/user/addfunds")
	public String addFunds(@RequestBody AddFunds addFunds) {
		return addFundBsL.addfunds(addFunds); 
	}
	
	@GetMapping(value = "/user/getfunds") 
	public List<AddFunds> getFunds() {
		return addFundBsL.getFundslist(); 
	}
	
	@PostMapping(value = "/user/addcredit")
	public String addCredit(@RequestBody User user) {
		return userBsL.addCredit(user);
	}

}