package com.cognizant.Airport.Service;

import java.util.List;

import com.cognizant.Airport.Model.AdminDetails;
import com.cognizant.Airport.Model.LoginDetails;
import com.cognizant.Airport.Model.ManagerDetails;

public interface IAirport {
	public AdminDetails adminreg(AdminDetails ad);

	public List<AdminDetails> adminreqList();

	public List<ManagerDetails> managerreqList();

	public void adminapproverequest(int id);

	public void managerapproverequest(int id);

	public String adminLogin(LoginDetails loginDetails);

	public AdminDetails getAdminDetails(int userId);

	
}
