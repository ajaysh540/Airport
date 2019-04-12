package com.cognizant.Airport.Service;

import java.util.List;

import com.cognizant.Airport.Model.HangarDetails;
import com.cognizant.Airport.Model.HangarStatus;
;


public interface IHangarDao {

	
	public HangarDetails getHangarDetails(int hId);
	public  void addHangarDetails(HangarDetails hd);
	public  void addHangarStatus(HangarStatus hs);
	public List<HangarDetails> getAllHangar();
	public void editHangarDetails(HangarDetails hangarDetails);
}
