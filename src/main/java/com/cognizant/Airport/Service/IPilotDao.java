package com.cognizant.Airport.Service;

import java.util.List;

import com.cognizant.Airport.Model.PilotDetails;

public interface IPilotDao {
	public int addPilotDetails(PilotDetails pilotDetails);

	public int removePilotDetails(int pid);

	public List<PilotDetails> pilotreqList();

	public PilotDetails editPilotDetails(int id);

	public void saveEditPilotDetails(PilotDetails pd);

	public PilotDetails getPilotDetails(int pid);
}
