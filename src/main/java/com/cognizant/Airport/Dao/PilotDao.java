package com.cognizant.Airport.Dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.cognizant.Airport.Model.PilotDetails;
import com.cognizant.Airport.Service.IPilotDao;

@Repository
public class PilotDao implements IPilotDao {

	public PilotDao() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int addPilotDetails(PilotDetails pilotDetails) {
		// TODO Auto-generated method stub
		entityManager.persist(pilotDetails);
		return 1;
	}

	@Override
	public int removePilotDetails(int pid) {
		PilotDetails details = entityManager.find(PilotDetails.class, pid);
		entityManager.remove(details);
		return 1;
	}

	@Override
	public List<PilotDetails> pilotreqList() { // Listing all pilot details
		// TODO Auto-generated method stub
		List<PilotDetails> li = null;
		String hql = "Select l from PilotDetails l ";
		TypedQuery<PilotDetails> query = entityManager.createQuery(hql, PilotDetails.class);

		li = query.getResultList();

		return li;
	}

	@Override
	public PilotDetails editPilotDetails(int id) { // Listing pilot details to edit
		// TODO Auto-generated method stub

		PilotDetails details = entityManager.find(PilotDetails.class, id);

		return details;
	}


	@Override
	public void saveEditPilotDetails(PilotDetails pd) { // saving and updating the details into DB
		// TODO Auto-generated method stub

		entityManager.merge(pd);
	}

	@Override
	public PilotDetails getPilotDetails(int pid) {
		// TODO Auto-generated method stub
		return entityManager.find(PilotDetails.class, pid);
	}

}
