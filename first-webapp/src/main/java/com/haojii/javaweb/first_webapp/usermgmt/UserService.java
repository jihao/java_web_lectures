package com.haojii.javaweb.first_webapp.usermgmt;

import java.util.HashMap;

import javax.servlet.ServletContext;

public class UserService {

	public static boolean login(String username, String password, ServletContext context) {	
		HashMap<String, User> userMap = getUserMapFromContext(context);
		User user = userMap.get(username);
		
		if (user != null ) {
			boolean isPasswordValid = user.getPassword().equals(password);
			return isPasswordValid;
		}
		else {
			return false;
		}
	}

	private static HashMap<String, User> getUserMapFromContext(
			ServletContext context) {
		HashMap<String,User> userMap = (HashMap<String,User>)context.getAttribute("userMap");
		return userMap;
	}
	
	public static User findUserByName(String username, ServletContext context) {	
		HashMap<String, User> userMap = getUserMapFromContext(context);
		User user = userMap.get(username);
		return user;
	}
}
