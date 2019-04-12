package com.cognizant.Airport.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//package com.cognizant.airport.models;
@Entity
@Table(name = "pilot_plane_details")
public class PilotPlaneDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "S_no")
	private int sNo;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pilots_pilot_id")
	private PilotDetails pilotDetails;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "planes_plane_id")
	private PlaneDetails planeDetails;

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public PilotDetails getPilotDetails() {
		return pilotDetails;
	}

	public void setPilotDetails(PilotDetails pilotDetails) {
		this.pilotDetails = pilotDetails;
	}

	public PlaneDetails getPlaneDetails() {
		return planeDetails;
	}

	public void setPlaneDetails(PlaneDetails planeDetails) {
		this.planeDetails = planeDetails;
	}

	@Override
	public String toString() {
		return "PilotPlaneDetails [sNo=" + sNo + ", pilotDetails=" + pilotDetails + ", planeDetails=" + planeDetails
				+ "]";
	}

}