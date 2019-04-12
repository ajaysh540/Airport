package com.cognizant.Airport.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Airport.Model.PilotDetails;
import com.cognizant.Airport.Model.PilotPlaneDetails;
import com.cognizant.Airport.Model.PlaneDetails;

@Service(value="assignPlanePilotService")
public class AssignPlanePilotService implements IAssignPlanePilot {

	@Autowired
	IAssignPlanePilot assignPlanePilot;
	
	@Override
	public List<PlaneDetails> getUnassignedPlane() {
		// TODO Auto-generated method stub
		return assignPlanePilot.getUnassignedPlane();
	}

	@Override
	public List<PilotDetails> getUnassignedPilot() {
		// TODO Auto-generated method stub
		return assignPlanePilot.getUnassignedPilot();
	}

	@Override
	public boolean assignPlaneToPilot(PilotPlaneDetails pilotPlaneDetails) {
		// TODO Auto-generated method stub
		return assignPlanePilot.assignPlaneToPilot(pilotPlaneDetails);
	}

	@Override
	public PilotDetails findPilotDetailsById(int pilotId) {
		// TODO Auto-generated method stub
		return assignPlanePilot.findPilotDetailsById(pilotId);
	}

	@Override
	public PlaneDetails findPlaneDetailsById(int planeId) {
		// TODO Auto-generated method stub
		return assignPlanePilot.findPlaneDetailsById(planeId);
	}

}
