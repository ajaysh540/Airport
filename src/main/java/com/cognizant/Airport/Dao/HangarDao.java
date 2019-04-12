package com.cognizant.Airport.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.Airport.Model.HangarDetails;
import com.cognizant.Airport.Model.HangarStatus;
import com.cognizant.Airport.Service.IHangarDao;

@Component
public class HangarDao implements IHangarDao {

	static Logger logger = Logger.getLogger(HangarDao.class);

	public HangarDao() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	public EntityManager entityManager;

	@Transactional
	@Override
	public void addHangarDetails(HangarDetails hd) {
		// TODO Auto-generated method stub

		logger.info(hd);
		entityManager.merge(hd);
	}

	@Transactional
	@Override
	public void addHangarStatus(HangarStatus hs) {
		// TODO Auto-generated method stub
		logger.info(hs);
		entityManager.merge(hs);
	}

	@Override
	public List<HangarDetails> getAllHangar() {
		// TODO Auto-generated method stub
		logger.info("HangarDetails getProduct");

		List<HangarDetails> li = null;
		String hql = "select l from HangarDetails l";
		TypedQuery<HangarDetails> query = entityManager.createQuery(hql, HangarDetails.class);
		li = query.getResultList();
		return li;
	}

	@Override
	public HangarDetails getHangarDetails(int hId) {
		return entityManager.find(HangarDetails.class, hId);
	}

	@Override
	public void editHangarDetails(HangarDetails hangarDetails) {
		entityManager.merge(hangarDetails);
		
	}

}
