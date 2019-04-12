package com.cognizant.Airport.Service;

import java.util.List;

import com.cognizant.Airport.Model.PilotDetails;
import com.cognizant.Airport.Model.PilotPlaneDetails;
import com.cognizant.Airport.Model.PlaneDetails;

public interface IAssignPlanePilot {

	public List<PlaneDetails> getUnassignedPlane();

	public List<PilotDetails> getUnassignedPilot();
	
	public boolean assignPlaneToPilot(PilotPlaneDetails pilotPlaneDetails);
	
	public PilotDetails findPilotDetailsById(int pilotId);
	
	public PlaneDetails findPlaneDetailsById(int planeId);
}
