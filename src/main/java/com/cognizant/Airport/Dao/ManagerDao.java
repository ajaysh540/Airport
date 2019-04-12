package com.cognizant.Airport.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.cognizant.Airport.Model.LoginDetails;
import com.cognizant.Airport.Model.ManagerDetails;
import com.cognizant.Airport.Service.IManagerDetailsService;

@Repository
public class ManagerDao implements IManagerDetailsService {
	@PersistenceContext
	public EntityManager entityManager;
	

	@Override
	public ManagerDetails saveManagerDetails(ManagerDetails managerDetails) {

		ManagerDetails managerDetail=entityManager.merge(managerDetails);
		return managerDetail;

	}

	@Override
	public String managerLogin(LoginDetails loginDetails) {
		ManagerDetails managerDetails = entityManager.find(ManagerDetails.class,LoginDetails.getUserId());
		System.out.println(managerDetails);
		if(managerDetails!=null) {
			if(managerDetails.getStatus()==0) { System.out.println("Account Not Activated.");	return "Account Not Activated.";}
			
		if(managerDetails.getPassword().equals(LoginDetails.getPassword())) {
			System.out.println(managerDetails.toString());
			return "success";
		}
		else {
			System.out.println("Wrong Password");
			return ("Wrong Password");
		}}
		
		else {
			System.out.println("Wrong UserId");
		return "Wrong UserId";
		}
	}

	@Override
	public ManagerDetails getManagerDetails(int i) {
		// TODO Auto-generated method stub
		return entityManager.find(ManagerDetails.class,i);
	}
}
