package com.cognizant.Airport.Service;

import java.util.List;

import com.cognizant.Airport.Model.HangarDetails;
import com.cognizant.Airport.Model.HangarStatus;
import com.cognizant.Airport.Model.PlaneDetails;
import com.cognizant.Airport.Model.PlaneHangarStatus;

public interface IAssignHangarPlane {
	public boolean assignHangarPlane(PlaneHangarStatus planeHangarStatus);

	public List<PlaneDetails> getUnassignedPlane();

	public List<HangarStatus> getUnassignedHangar();
	
	public HangarDetails findHangarDetailsById(int hangarId);
	
	public PlaneDetails findPlaneDetailsById(int planeId);
	
	public boolean updateHangarStatusDetails(int hangarId, String availableFD, String availableTD, String occupancyFD, String occupancyTD);
}
