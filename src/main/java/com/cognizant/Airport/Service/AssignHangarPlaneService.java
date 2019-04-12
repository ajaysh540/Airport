package com.cognizant.Airport.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Airport.Model.HangarDetails;
import com.cognizant.Airport.Model.HangarStatus;
import com.cognizant.Airport.Model.PlaneDetails;
import com.cognizant.Airport.Model.PlaneHangarStatus;

@Service(value="assignHangarPlaneService")
public class AssignHangarPlaneService implements IAssignHangarPlane {

	@Autowired
	IAssignHangarPlane assignHangarPlane;
	
	@Override
	public boolean assignHangarPlane(PlaneHangarStatus planeHangarStatus) {
		// TODO Auto-generated method stub
		return assignHangarPlane.assignHangarPlane(planeHangarStatus);
	}

	@Override
	public List<PlaneDetails> getUnassignedPlane() {
		// TODO Auto-generated method stub
		return assignHangarPlane.getUnassignedPlane();
	}

	@Override
	public List<HangarStatus> getUnassignedHangar() {
		// TODO Auto-generated method stub
		return assignHangarPlane.getUnassignedHangar();
	}

	@Override
	public HangarDetails findHangarDetailsById(int hangarId) {
		// TODO Auto-generated method stub
		return assignHangarPlane.findHangarDetailsById(hangarId);
	}

	@Override
	public PlaneDetails findPlaneDetailsById(int planeId) {
		// TODO Auto-generated method stub
		return assignHangarPlane.findPlaneDetailsById(planeId);
	}

	@Override
	public boolean updateHangarStatusDetails(int hangarId, String availableFD, String availableTD, String occupancyFD, String occupancyTD) {
		// TODO Auto-generated method stub
		return assignHangarPlane.updateHangarStatusDetails(hangarId, availableFD, availableTD, occupancyFD, occupancyTD);
	}
	
}
