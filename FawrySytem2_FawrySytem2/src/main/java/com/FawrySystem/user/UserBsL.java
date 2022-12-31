package com.FawrySystem.user;

import java.security.PublicKey; 
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.FawrySystem.Payment.AddFundBsL;
import com.FawrySystem.Payment.CreditCard;

@Service
public class UserBsL {
	
	private static List<User> users;

	public UserBsL() {
		this.users = new ArrayList<>();
	}
	public UserBsL(List<User> users) {
		this.users = users;
	}

	public String add(User user) { 
		for (User iuser : users) {
			if(user.getUserName().equals(iuser.getUserName())) {
				return "This is already found"; 
			}
		}
		users.add(user); 
		return "Added successfully";
	} 

	
	public static User getuser(String username) {
		for (User iuser : users) {
			if(iuser.getUserName().equalsIgnoreCase(username)) {
				return iuser; 
			}
		}
		return null;
	}
	
	public String Signin(User user) {
		for (User iuser : users) {
			if(iuser.getEmail().equalsIgnoreCase(user.getEmail())) {
				return "Sign in Successfully.."; 
			}
		}
		return "There is no account with this email.."; 
	}
	
	public String addCredit(User user) {
		for (User iuser : users) {
			if(iuser.getUserName().equalsIgnoreCase(user.getUserName())) {
				iuser.setCreditCard(user.getCreditCard());
				return "Creditcard added..";
			}
		}
		return "Failed..";
	}
}