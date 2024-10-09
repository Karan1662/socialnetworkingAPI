package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@RequestMapping("/Social")
	public String Welcome () {
		
		return "Welcome to the world of Social Networking";
		
	}

}
