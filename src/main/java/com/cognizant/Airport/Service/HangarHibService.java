package com.cognizant.Airport.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.Airport.Model.HangarDetails;
import com.cognizant.Airport.Model.HangarStatus;

@Service(value = "HangarHibService")
public class HangarHibService implements IHangarDao {

	public HangarHibService() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	IHangarDao hangarDao;

	@Override
	public void addHangarDetails(HangarDetails hd) {
		// TODO Auto-generated method stub
		hangarDao.addHangarDetails(hd);
	}

	@Override
	public void addHangarStatus(HangarStatus hs) {
		// TODO Auto-generated method stub
		hangarDao.addHangarStatus(hs);
	}

	@Override
	public List<HangarDetails> getAllHangar() {
		// TODO Auto-generated method stub
		return hangarDao.getAllHangar();
	}

	@Override
	public HangarDetails getHangarDetails(int hId) {
		// TODO Auto-generated method stub
		return hangarDao.getHangarDetails(hId);
	}

	@Transactional
	@Override
	public void editHangarDetails(HangarDetails hangarDetails) {
		// TODO Auto-generated method stub
		hangarDao.editHangarDetails(hangarDetails);
	}

}
