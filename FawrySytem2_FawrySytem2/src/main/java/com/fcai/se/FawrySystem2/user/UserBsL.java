package com.fcai.se.FawrySystem2.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserBsL {
	
	private List<User> users;

	public UserBsL() {
		this.users = new ArrayList<>();
	}
	public UserBsL(List<User> users) {
		this.users = users;
	}

	public String add(User user) {
		for (User iuser : users) {
			if(user.getUserName() == iuser.getUserName()) {
				return "This is already found";
			}
		}
		users.add(user);
		return "Added successfully";
	}

	
	public User getuser(String username) {
		for (User iuser : users) {
			if(iuser.getUserName().equalsIgnoreCase(username)) {
				return iuser; 
			}
		}
		return null;
	}
}