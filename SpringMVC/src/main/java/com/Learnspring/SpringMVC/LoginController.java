package com.Learnspring.SpringMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Learnspring.Jee.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "hello";
	}

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String welocmeUser(ModelMap model, @RequestParam String name, @RequestParam String password) {
		model.put("name", name);
		model.put("password", password);
		if(service.validateUser(name, password)) {
			 return "welcome1";
		}
		else {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		
	}

}
