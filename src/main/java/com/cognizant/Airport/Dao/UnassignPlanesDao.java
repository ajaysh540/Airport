package com.cognizant.Airport.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.cognizant.Airport.Model.HangarStatus;
import com.cognizant.Airport.Model.PlaneHangarStatus;
import com.cognizant.Airport.Service.IUnassignPlane;

@Repository
public class UnassignPlanesDao implements IUnassignPlane {

	@PersistenceContext
	public EntityManager entityManager;
	
	@Override
	public List<HangarStatus> getAssignedHangar() {
		System.out.println("\n\n\n\n\n\n\n\\n\n\n\n\\n\n\nin method");
		TypedQuery<HangarStatus> query=entityManager.createQuery("Select h from HangarStatus h where h.status='N'",HangarStatus.class);
		return query.getResultList();
	}

	@Override
	public void unassignHangar(String hangarId) {
		System.out.println("\n\n\\n\n\n\n\n\n"+hangarId);
		TypedQuery<HangarStatus> query=entityManager.createQuery("Select h from HangarStatus h where h.hangarDetails.hangarId="+hangarId,HangarStatus.class);
		HangarStatus hangarStatus=query.getSingleResult();
		hangarStatus.setAvailableFD(null);
		hangarStatus.setAvailableTD(null);
		hangarStatus.setStatus("A");
		hangarStatus.setOccupancyFD(null);
		hangarStatus.setOccupancyTD(null);
		TypedQuery<PlaneHangarStatus> q=entityManager.createQuery("Select ph from PlaneHangarStatus ph where ph.hangarDetails.hangarId="+hangarId,PlaneHangarStatus.class);
		PlaneHangarStatus planeHangarStatus=q.getSingleResult();
		entityManager.remove(planeHangarStatus);
	}

}
