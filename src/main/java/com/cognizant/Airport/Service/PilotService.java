package com.cognizant.Airport.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.Airport.Dao.PilotDao;
import com.cognizant.Airport.Model.PilotDetails;

@Service(value="pilotService")
public class PilotService implements IPilotDao {
   
	
	@Autowired
	PilotDao dao;	
	
	public PilotService() {
		// TODO Auto-generated constructor stub
	}
	@Transactional
	@Override
	public int addPilotDetails(PilotDetails pilotDetails) {
		// TODO Auto-generated method stub
		return dao.addPilotDetails(pilotDetails);
	}
	
	@Transactional
	@Override
	public int removePilotDetails(int pid) {
		// TODO Auto-generated method stub
		return dao.removePilotDetails(pid);
	}

	@Override
	public List<PilotDetails> pilotreqList() {
		// TODO Auto-generated method stub
		return dao.pilotreqList();
	}
	@Transactional
	@Override
	public PilotDetails editPilotDetails(int id) {
		// TODO Auto-generated method stub
		return dao.editPilotDetails(id);
	}

	@Transactional
	@Override
	public void saveEditPilotDetails(PilotDetails pd) {
		// TODO Auto-generated method stub
		dao.saveEditPilotDetails(pd);
	}


	@Override
	public PilotDetails getPilotDetails(int pid) {
		// TODO Auto-generated method stub
		return dao.getPilotDetails(pid);
	}

}
