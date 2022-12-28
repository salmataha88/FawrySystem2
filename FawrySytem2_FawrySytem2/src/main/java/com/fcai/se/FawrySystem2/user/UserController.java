package com.fcai.se.FawrySystem2.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController 
public class UserController {
	
	private UserBsL userBsL;  

	public UserController(UserBsL userBsL) {
		this.userBsL = userBsL;
	}

	@RequestMapping(value = "/user/signup" , method = RequestMethod.POST)
	public String adduser(@RequestBody User user) {
		return userBsL.add(user);  
	}
	
	@GetMapping(value = "/user/{username}")
	public User getuser(@PathVariable("username") String username) {
		return userBsL.getuser(username); 
	}
}
