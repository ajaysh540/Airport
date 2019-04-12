package com.cognizant.Airport.Service;

import com.cognizant.Airport.Model.LoginDetails;
import com.cognizant.Airport.Model.ManagerDetails;

public interface IManagerDetailsService {
	public ManagerDetails saveManagerDetails(ManagerDetails managerDetails);
	public String managerLogin(LoginDetails loginDetails);
	public ManagerDetails getManagerDetails(int i);
}
