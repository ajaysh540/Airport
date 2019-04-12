package com.cognizant.Airport.Dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import com.cognizant.Airport.Model.AdminDetails;
import com.cognizant.Airport.Model.LoginDetails;
import com.cognizant.Airport.Model.ManagerDetails;
import com.cognizant.Airport.Service.IAirport;

@Component
public class AdminDao implements IAirport {

	private AdminDao() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	public EntityManager entityManager;

	@Transactional
	@Override
	public AdminDetails adminreg(AdminDetails ad) {
		// TODO Auto-generated method stub
		AdminDetails adminDetails=entityManager.merge(ad);
		System.out.println(adminDetails.toString());
		return adminDetails;
	}

	@Override
	public List<AdminDetails> adminreqList() {
		// TODO Auto-generated method stub
		List<AdminDetails> li = null;
		String hql = "Select l from AdminDetails l where l.status=?";
		TypedQuery<AdminDetails> query = entityManager.createQuery(hql, AdminDetails.class);
		query.setParameter(0, 0);
		li = query.getResultList();

		return li;
	}

	@Override
	public List<ManagerDetails> managerreqList() {
		// TODO Auto-generated method stub
		List<ManagerDetails> li = null;
		String hql = "Select l from ManagerDetails l where l.status=?";
		TypedQuery<ManagerDetails> query = entityManager.createQuery(hql, ManagerDetails.class);
		query.setParameter(0, 0);
		li = query.getResultList();

		return li;
	}

	@Transactional
	@Override
	public void adminapproverequest(int id) {
		AdminDetails details = entityManager.find(AdminDetails.class, id);
		details.setStatus(1);
		entityManager.merge(details);
	}

	@Transactional
	@Override
	public void managerapproverequest(int id) {
		// TODO Auto-generated method stub
		ManagerDetails details = entityManager.find(ManagerDetails.class, id);
		details.setStatus(1);
		entityManager.merge(details);
	}

	@Override
	public String adminLogin(LoginDetails loginDetails) {
		AdminDetails adminDetails = entityManager.find(AdminDetails.class, LoginDetails.getUserId());

		if (adminDetails != null) {
			if (adminDetails.getStatus() == 0) {
				System.out.println("Account Not Activated.");
				return "Account Not Activated.";
			}

			if (adminDetails.getPassword().equals(LoginDetails.getPassword())) {
				System.out.println(adminDetails.toString());
				return "success";
			} else {
				System.out.println("Wrong Password");
				return ("Wrong Password");
			}
		}

		else {
			System.out.println("Wrong UserId");
			return "Wrong UserId";
		}
	}

	@Override
	public AdminDetails getAdminDetails(int userId) {

		return entityManager.find(AdminDetails.class, userId);
	}

	



}
