package com.cognizant.Airport.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.cognizant.Airport.Model.PlaneDetails;
import com.cognizant.Airport.Service.IAddPlane;

@Repository
public class AddPlaneDao implements IAddPlane {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean addPlane(PlaneDetails planeDetails) {
		entityManager.merge(planeDetails);
		return false;
	}

	@Override
	public List<PlaneDetails> viewAllPlanes() {
		List<PlaneDetails> li = null;
		String hql = "select l from PlaneDetails l";
		TypedQuery<PlaneDetails> query = entityManager.createQuery(hql, PlaneDetails.class);
		li = query.getResultList();
		return li;

	}

	@Override
	public void updatePlane(PlaneDetails planeDetails) {
		
		entityManager.merge(planeDetails);
	}

	@Override
	public PlaneDetails viewDetails(Integer pid) {
		PlaneDetails pd=entityManager.find(PlaneDetails.class,pid);
		return pd;
	}

}
