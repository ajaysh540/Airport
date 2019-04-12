package com.cognizant.Airport.Service;


import java.util.List;

import com.cognizant.Airport.Model.PlaneDetails;

public interface IAddPlane {
	public boolean addPlane(PlaneDetails planeDetails);

	public List<PlaneDetails> viewAllPlanes();
	public void updatePlane(PlaneDetails planeDetails);

	public PlaneDetails viewDetails(Integer pid);
}
