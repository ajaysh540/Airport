package com.cognizant.Airport.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.Airport.Model.PilotDetails;
import com.cognizant.Airport.Model.PilotPlaneDetails;
import com.cognizant.Airport.Model.PlaneDetails;
import com.cognizant.Airport.Service.IAssignPlanePilot;

@Component
public class AssignPlanePilotDao implements IAssignPlanePilot{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<PlaneDetails> getUnassignedPlane() {
		// TODO Auto-generated method stub
		//String hql="SELECT p.planeId FROM PlaneDetails p WHERE p.planeId NOT IN (SELECT phd.planes_plane_id FROM PlaneHangarStatus phd) AND (SELECT ppd.planes_plane_id FROM PilotPlaneDetails ppd)";
		String hql="SELECT p FROM PlaneDetails p WHERE p.planeId NOT IN (SELECT phd.planeDetails FROM PlaneHangarStatus phd) AND p.planeId NOT IN (SELECT ppd.planeDetails FROM PilotPlaneDetails ppd)";
		TypedQuery<PlaneDetails> query = entityManager.createQuery(hql,PlaneDetails.class);
		List<PlaneDetails> list = query.getResultList();
		return list;
	}

	@Override
	public List<PilotDetails> getUnassignedPilot() {
		// TODO Auto-generated method stub
		List<PilotDetails> list = null;
		//String hql="SELECT p.PilotId FROM PilotDetails p WHERE p.PilotId NOT IN (SELECT ppd.pilots_plane_id FROM PilotPlaneDetails ppd)";
		String hql="SELECT p FROM PilotDetails p WHERE p.pilotId NOT IN (SELECT ppd.pilotDetails FROM PilotPlaneDetails ppd)";
		TypedQuery<PilotDetails> query = entityManager.createQuery(hql, PilotDetails.class);
		list = query.getResultList();
		return list;
	}

	@Transactional
	@Override
	public boolean assignPlaneToPilot(PilotPlaneDetails pilotPlaneDetails) {
		// TODO Auto-generated method stub
		entityManager.merge(pilotPlaneDetails);
		return true;
	}

	@Override
	public PilotDetails findPilotDetailsById(int pilotId) {
		// TODO Auto-generated method stub
		PilotDetails pilotDetails = entityManager.find(PilotDetails.class, pilotId);
		return pilotDetails;
	}

	@Override
	public PlaneDetails findPlaneDetailsById(int planeId) {
		// TODO Auto-generated method stub
		PlaneDetails planeDetails = entityManager.find(PlaneDetails.class, planeId);
		return planeDetails;
	}

}
