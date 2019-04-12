package com.cognizant.Airport.Service;

import java.util.List;

import com.cognizant.Airport.Model.HangarStatus;


public interface IUnassignPlane {
	public List<HangarStatus> getAssignedHangar();
	public void unassignHangar(String hangarId);
}
