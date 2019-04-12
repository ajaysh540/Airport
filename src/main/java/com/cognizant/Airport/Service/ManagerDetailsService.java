package com.cognizant.Airport.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.Airport.Dao.ManagerDao;
import com.cognizant.Airport.Model.LoginDetails;
import com.cognizant.Airport.Model.ManagerDetails;


@Service(value="managerDetailsService")
public class ManagerDetailsService implements IManagerDetailsService {

	@Autowired
	ManagerDao managerDao;
	@Transactional
	@Override
	public ManagerDetails saveManagerDetails(ManagerDetails managerDetails) {
	return managerDao.saveManagerDetails(managerDetails);	

	}
	@Transactional
	@Override
	public String managerLogin(LoginDetails loginDetails) {
		
		return managerDao.managerLogin(loginDetails);
	}
	@Override
	public ManagerDetails getManagerDetails(int i) {
		// TODO Auto-generated method stub
		return managerDao.getManagerDetails(i);
	}


}
