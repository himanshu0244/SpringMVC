package com.Learnspring.Jee;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("himanshu") && password.equals("123");
	}
}
