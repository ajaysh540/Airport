package com.cognizant.Airport.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Airport.Model.AdminDetails;
import com.cognizant.Airport.Model.LoginDetails;
import com.cognizant.Airport.Model.ManagerDetails;




@Service(value="adminService")
public class AdminDetailsService implements IAirport {

	public AdminDetailsService() {
		// TODO Auto-generated constructor stub
	}

	
	@Autowired
	IAirport airportDAO;


	@Override
	public AdminDetails adminreg(AdminDetails ad) {
		return airportDAO.adminreg(ad);
	}


	@Override
	public List<AdminDetails> adminreqList() {
		// TODO Auto-generated method stub
		return airportDAO.adminreqList();
	}


	@Override
	public void adminapproverequest(int id) {
		// TODO Auto-generated method stub
		airportDAO.adminapproverequest(id);
	}


	@Override
	public List<ManagerDetails> managerreqList() {
		// TODO Auto-generated method stub
		return airportDAO.managerreqList();
	}


	@Override
	public void managerapproverequest(int id) {
		// TODO Auto-generated method stub
		airportDAO.managerapproverequest(id);
	}


	@Override
	public String adminLogin(LoginDetails loginDetails) {
		// TODO Auto-generated method stub
		return airportDAO.adminLogin(loginDetails);
	}


	@Override
	public AdminDetails getAdminDetails(int userId) {
		// TODO Auto-generated method stub
		return airportDAO.getAdminDetails(userId);
	}




	
	
	

}
