package com.FawrySytem;

import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.FawrySystem.user.*;

@SpringBootApplication(scanBasePackages = {"com.FawrySystem.user", "com.FawrySystem","com.FawrySystem.Payment" ,"com.FawrySystem.Discount","com.FawrySystem.Services","com.FawrySystem.Refund", "com.FawrySystem.Providers"})
public class FawrySytem2Application {

	public static void main(String[] args) {
		SpringApplication.run(FawrySytem2Application.class, args);
	}

}
 