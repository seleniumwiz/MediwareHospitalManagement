package core;

import java.util.HashMap;


public class Data {
	
	/*
	 * storing the values direactly to  hashmap and using in code
	 */

	public static HashMap<String, String> getUserinfo() {
		HashMap<String, String> userMap = new HashMap<String, String>();
		userMap.put("Outpatient", "opuser_123");
		return userMap;

	}

	public static HashMap<String, Integer> SendEmail() {
		HashMap<String, Integer> userMap = new HashMap<String, Integer>();
		userMap.put("PORT", 465);
		return userMap;

	}

	public static HashMap<String, String> Emailcredentials() {
		HashMap<String, String> credentials = new HashMap<String, String>();
		credentials.put("hostname", "smtp.gmail.com");
		credentials.put("username", "tselenium306@gmail.com");
		credentials.put("password","selenium@123");
		credentials.put("emailto", "manumohandask@gmail.com");
		return credentials;

	}
	

	


	
	
	
	
	

}