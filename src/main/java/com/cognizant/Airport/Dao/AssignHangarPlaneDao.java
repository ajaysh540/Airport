package com.cognizant.Airport.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.Airport.Model.HangarDetails;
import com.cognizant.Airport.Model.HangarStatus;
import com.cognizant.Airport.Model.PlaneDetails;
import com.cognizant.Airport.Model.PlaneHangarStatus;
import com.cognizant.Airport.Service.IAssignHangarPlane;

@Component
public class AssignHangarPlaneDao implements IAssignHangarPlane {

	@PersistenceContext
	private EntityManager entityManager;
	
	private static AssignHangarPlaneDao assignHangarPlaneDao = null;
	private AssignHangarPlaneDao() {
		// TODO Auto-generated constructor stub
	}
	public static AssignHangarPlaneDao getAssignHangarPlaneDao() {
		if(assignHangarPlaneDao == null)
			return assignHangarPlaneDao;
		return new AssignHangarPlaneDao();
	}
	
	@Override
	public List<PlaneDetails> getUnassignedPlane() {
		// TODO Auto-generated method stub
		//String hql="SELECT p.planeId FROM PlaneDetails p WHERE p.planeId NOT IN (SELECT phd.planes_plane_id FROM PlaneHangarStatus phd) AND (SELECT ppd.planes_plane_id FROM PilotPlaneDetails ppd)";
		String hql="SELECT pd FROM PlaneDetails pd WHERE pd.planeId NOT IN (SELECT phd.planeDetails FROM PlaneHangarStatus phd) AND pd.planeId NOT IN (SELECT ppd.planeDetails FROM PilotPlaneDetails ppd)";
		TypedQuery<PlaneDetails> query = entityManager.createQuery(hql,PlaneDetails.class);
		List<PlaneDetails> list = query.getResultList();
		return list;
	}
	
	@Transactional
	@Override
	public boolean assignHangarPlane(PlaneHangarStatus planeHangarStatus) {
		// TODO Auto-generated method stub
		entityManager.persist(planeHangarStatus);
		return true;
	}

	@Override
	public List<HangarStatus> getUnassignedHangar() {
		// TODO Auto-generated method stub
		String hql="SELECT h FROM HangarStatus h WHERE h.status='A'";
		TypedQuery<HangarStatus> query = entityManager.createQuery(hql,HangarStatus.class);
		List<HangarStatus> list = query.getResultList();
		return list;
	}
	@Override
	public HangarDetails findHangarDetailsById(int hangarId) {
		// TODO Auto-generated method stub
		String hql="SELECT h FROM HangarDetails h WHERE h.hangarId="+hangarId;
		TypedQuery<HangarDetails> query = entityManager.createQuery(hql,HangarDetails.class);
		HangarDetails hangarStatus = query.getSingleResult();
		return hangarStatus;
	}
	@Override
	public PlaneDetails findPlaneDetailsById(int planeId) {
		// TODO Auto-generated method stub
		PlaneDetails planeDetails = entityManager.find(PlaneDetails.class, planeId);
		return planeDetails;
	}
	@Transactional
	@Override
	public boolean updateHangarStatusDetails(int hangarId, String availableFD, String availableTD, String occupancyFD, String occupancyTD) {
		// TODO Auto-generated method stub
		String hql = "SELECT hs FROM HangarStatus hs WHERE hs.hangarDetails.hangarId="+hangarId;
		TypedQuery<HangarStatus> query = entityManager.createQuery(hql,HangarStatus.class);
		HangarStatus hangarStatus = query.getSingleResult();
		hangarStatus.setStatus("N");
		hangarStatus.setAvailableFD(availableFD);
		hangarStatus.setAvailableTD(availableTD);
		hangarStatus.setOccupancyFD(occupancyFD);
		hangarStatus.setOccupancyTD(occupancyTD);
		entityManager.merge(hangarStatus);
		return true;
	}

}
