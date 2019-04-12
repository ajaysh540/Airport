package com.cognizant.Airport.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Airport.Model.HangarStatus;

@Service(value="unassignPlaneService")
public class UnassignPlaneService implements IUnassignPlane{

	@Autowired
	IUnassignPlane unassignPlane;
	@Override
	public List<HangarStatus> getAssignedHangar() {
		// TODO Auto-generated method stub
		return unassignPlane.getAssignedHangar();
	}
	@Transactional
	@Override
	public void unassignHangar(String hangarId) {
	unassignPlane.unassignHangar(hangarId);
		
	}

}
