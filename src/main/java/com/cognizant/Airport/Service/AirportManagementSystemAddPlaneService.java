package com.cognizant.Airport.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.Airport.Dao.AddPlaneDao;
import com.cognizant.Airport.Model.PlaneDetails;
import com.cognizant.Airport.Service.IAddPlane;

@Service("AddPlaneService")
public class AirportManagementSystemAddPlaneService implements IAddPlane {

	@Autowired
	AddPlaneDao addPlaneDao;
	
	@Transactional
	@Override
	public boolean addPlane(PlaneDetails planeDetails) {
		// TODO Auto-generated method stub
		return addPlaneDao.addPlane(planeDetails);
	}

	@Override
	public List<PlaneDetails> viewAllPlanes() {
		// TODO Auto-generated method stub
		return addPlaneDao.viewAllPlanes();
	}
	@Transactional
	@Override
	public void updatePlane(PlaneDetails planeDetails) {
		addPlaneDao.updatePlane(planeDetails);
	}

	@Override
	public PlaneDetails viewDetails(Integer pid) {
		// TODO Auto-generated method stub
		return addPlaneDao.viewDetails(pid);
	}

}
