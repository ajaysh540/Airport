package com.cognizant.Airport.Model;


public class LoginDetails {
	private static int userId;
	private static String password;
	private static String profile;
	private LoginDetails() {
		// TODO Auto-generated constructor stub
	}
	
	static private LoginDetails loginDetails;
	
	public static LoginDetails getLoginDetails() {
		if(loginDetails==null) loginDetails=new LoginDetails();
		return loginDetails;
	}
	
	
	
	@Override
	public String toString() {
		return "LoginDetails [userId=" + userId + ", password=" + password + ", profile=" + profile + "]";
	}

	public static int getUserId() {
		return userId;
	}

	public static void setUserId(int userId) {
		LoginDetails.userId = userId;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		LoginDetails.password = password;
	}

	public static String getProfile() {
		return profile;
	}

	public static void setProfile(String profile) {
		LoginDetails.profile = profile;
	}

	
	

}
